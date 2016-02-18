package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.Customer;
import org.egreen.opensms.server.entity.Customerorder;
import org.egreen.opensms.server.entity.CustomerorderPK;
import org.egreen.opensms.server.entity.DeliveryPoint;
import org.egreen.opensms.server.models.CustomerOrderDetails;
import org.egreen.opensms.server.models.CustomerRequestModel;
import org.egreen.opensms.server.service.CustomerDAOService;
import org.egreen.opensms.server.service.CustomerOrderDAOService;
import org.egreen.opensms.server.service.DeliveryPointDAOService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pramoda Fernando on 3/20/2015.
 */
@Controller
@RequestMapping("fmms/customerorder")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderDAOService customerOrderDAOService;

    @Autowired
    private CustomerDAOService customerDAOService;

    @Autowired
    private DeliveryPointDAOService pumpingDetailsDAOService;


    /**
     *
     * Save
     *
     * @param customerorder
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage save(@RequestBody Customerorder customerorder) {
        CustomerorderPK res = customerOrderDAOService.save(customerorder);
        ResponseMessage responseMessage;
        if(res != null){
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        }else{
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    /**
     *
     * update
     *
     * @param customerorder
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage update(@RequestBody Customerorder customerorder) {
        int res = customerOrderDAOService.update(customerorder);
        ResponseMessage responseMessage;
        if(res > 0){
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        }else{
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    /**
     *
     * getAllCustomerRequests
     *
     * @return
     */
    @RequestMapping(value = "getAllCustomerRequests", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage getAllCustomerRequests() {
        List<CustomerRequestModel>customerRequestModelList  = new ArrayList<CustomerRequestModel>();
        List<Customerorder> customerorderList =  new ArrayList<Customerorder>();
        List<DeliveryPoint>pumpingDetailsList =  new ArrayList<DeliveryPoint>();
        List<Customer> all_customer_details = customerDAOService.get_all_customer_details();
        for (Customer customer : all_customer_details) {
            CustomerRequestModel customerRequestModel =  new CustomerRequestModel();
            customerRequestModel.setCustomer(customer);
            List<Customerorder> ordersList = customerOrderDAOService.getCustomerOrderbyCustomerId(customer.getCustId());
            for (Customerorder customerorder : ordersList) {
                customerRequestModel.setCustomerorderlist(customerorderList);
                DeliveryPoint pumpingdetail=pumpingDetailsDAOService.getPumpingDetailById(customerorder.getPumpingId());
                customerorderList.add(customerorder);
                pumpingDetailsList.add(pumpingdetail);
                customerRequestModel.setPumpingdetailslist(pumpingDetailsList);
                customerRequestModelList.add(customerRequestModel);
            }
        }
        ResponseMessage responseMessage = null;
            if(customerRequestModelList != null){
                responseMessage = ResponseMessage.SUCCESS;
                responseMessage.setData(customerRequestModelList);
            }else{
                responseMessage = ResponseMessage.DANGER;
                responseMessage.setData(customerRequestModelList);
            }
        return responseMessage;
    }


    /**
     *
     * viewCustomerOrderDetails
     *
     * @return
     */
    @RequestMapping(value = "viewCustomerOrderDetails", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage viewCustomerOrderDetails() {

        List<CustomerOrderDetails> customerOrderDetailsList = new ArrayList<CustomerOrderDetails>();

        List<Customerorder> customerorderList = customerOrderDAOService.getAllCustomerOrders();
        for (Customerorder customerorder : customerorderList) {
            DeliveryPoint pumpingDetail = pumpingDetailsDAOService.getPumpingDetailById(customerorder.getPumpingId());
            Customer customer = customerDAOService.getCustomerDetailsById(customerorder.getCustomerId());

            CustomerOrderDetails customerOrderDetails = new CustomerOrderDetails();

            customerOrderDetails.setCustomerOrderId(customerorder.getOrderId());
            customerOrderDetails.setCustomerId(customerorder.getCustomerId());
            customerOrderDetails.setCustomerName(customer.getName());
            customerOrderDetails.setOrderdate(customerorder.getOrderdate());
            customerOrderDetails.setStatus(customerorder.getStatus());
            customerOrderDetails.setFuelType(customerorder.getFuelType());
            customerOrderDetails.setVolume(customerorder.getVolume());

            customerOrderDetails.setPumpingDetails(pumpingDetail);

            customerOrderDetailsList.add(customerOrderDetails);
        }
        ResponseMessage responseMessage = null;
        if (customerOrderDetailsList != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(customerOrderDetailsList);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(customerOrderDetailsList);
        }
        return responseMessage;
    }

    /**
     *
     * viewCustomerOrderDetailsByCustomerId
     *
     *
     * @param customerId
     * @return
     */
    @RequestMapping(value = "viewCustomerOrderDetailsByCustomerId", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage viewCustomerOrderDetailsByCustomerId(@RequestParam("customerId")Long customerId) {
        List<CustomerOrderDetails> customerOrderDetailsList = new ArrayList<CustomerOrderDetails>();
        List<Customerorder> customerorderList = customerOrderDAOService.getCustomerOrderbyCustomerId(customerId);
        for (Customerorder customerorder : customerorderList) {
            DeliveryPoint pumpingDetail = pumpingDetailsDAOService.getPumpingDetailById(customerorder.getPumpingId());
            Customer customer = customerDAOService.getCustomerDetailsById(customerorder.getCustomerId());
            CustomerOrderDetails customerOrderDetails = new CustomerOrderDetails();
            customerOrderDetails.setCustomerOrderId(customerorder.getOrderId());
            customerOrderDetails.setCustomerId(customerorder.getCustomerId());
            customerOrderDetails.setCustomerName(customer.getName());
            customerOrderDetails.setOrderdate(customerorder.getOrderdate());
            customerOrderDetails.setStatus(customerorder.getStatus());
            customerOrderDetails.setFuelType(customerorder.getFuelType());
            customerOrderDetails.setVolume(customerorder.getVolume());
            customerOrderDetails.setPumpingDetails(pumpingDetail);
            customerOrderDetailsList.add(customerOrderDetails);
        }
        ResponseMessage responseMessage = null;
        if (customerOrderDetailsList != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(customerOrderDetailsList);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(customerOrderDetailsList);
        }
        return responseMessage;
    }


    @RequestMapping(value = "viewChartByFuelType", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage viewChartByFuelType(@RequestParam("customerId")Long customerId) {
        List<CustomerOrderDetails> customerOrderDetailsList = new ArrayList<CustomerOrderDetails>();
        List<Customerorder> customerorderList = customerOrderDAOService.getCustomerOrderbyCustomerId(customerId);
        for (Customerorder customerorder : customerorderList) {
            DeliveryPoint pumpingDetail = pumpingDetailsDAOService.getPumpingDetailById(customerorder.getPumpingId());
            Customer customer = customerDAOService.getCustomerDetailsById(customerorder.getCustomerId());
            CustomerOrderDetails customerOrderDetails = new CustomerOrderDetails();
            customerOrderDetails.setCustomerOrderId(customerorder.getOrderId());
            customerOrderDetails.setCustomerId(customerorder.getCustomerId());
            customerOrderDetails.setCustomerName(customer.getName());
            customerOrderDetails.setOrderdate(customerorder.getOrderdate());
            customerOrderDetails.setStatus(customerorder.getStatus());
            customerOrderDetails.setFuelType(customerorder.getFuelType());
            customerOrderDetails.setVolume(customerorder.getVolume());
            customerOrderDetails.setPumpingDetails(pumpingDetail);
            customerOrderDetailsList.add(customerOrderDetails);
        }

    ResponseMessage responseMessage = null;
        if (customerOrderDetailsList != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(customerOrderDetailsList);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(customerOrderDetailsList);
        }
        return responseMessage;
    }

    /**
     *
     * viewCustomerOrderDaily
     *
     * @return
     */
    @RequestMapping(value = "viewCustomerOrderDaily", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage viewCustomerOrderDaily() {

        List<CustomerOrderDetails> customerOrderDetailsList = new ArrayList<CustomerOrderDetails>();

        List<Customerorder> customerorderList = customerOrderDAOService.dailyRequestDetails();
        for (Customerorder customerorder : customerorderList) {
            DeliveryPoint pumpingDetail = pumpingDetailsDAOService.getPumpingDetailById(customerorder.getPumpingId());
            Customer customer = customerDAOService.getCustomerDetailsById(customerorder.getCustomerId());

            CustomerOrderDetails customerOrderDetails = new CustomerOrderDetails();

            customerOrderDetails.setCustomerOrderId(customerorder.getOrderId());
            customerOrderDetails.setCustomerId(customerorder.getCustomerId());
            customerOrderDetails.setCustomerName(customer.getName());
            customerOrderDetails.setOrderdate(customerorder.getOrderdate());
            customerOrderDetails.setStatus(customerorder.getStatus());
            customerOrderDetails.setFuelType(customerorder.getFuelType());
            customerOrderDetails.setVolume(customerorder.getVolume());
            customerOrderDetails.setRate(customerorder.getRate());

            customerOrderDetails.setPumpingDetails(pumpingDetail);
            customerOrderDetails.setStoreManagerAproval(customerorder.getStoreManagerAproval());

            customerOrderDetailsList.add(customerOrderDetails);
        }
        ResponseMessage responseMessage = null;
        if (customerOrderDetailsList != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(customerOrderDetailsList);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(customerOrderDetailsList);
        }
        return responseMessage;
    }


    /**
     *
     * getAll Pending Customer Order
     *
     * @return
     */
    @RequestMapping(value = "pendingCustomerOrder", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage pendingCustomerOrder() {

        List<CustomerOrderDetails> customerOrderDetailsList = new ArrayList<CustomerOrderDetails>();

        List<Customerorder> customerorderList = customerOrderDAOService.pendingCustomerOrder();
        for (Customerorder customerorder : customerorderList) {
            DeliveryPoint pumpingDetail = pumpingDetailsDAOService.getPumpingDetailById(customerorder.getPumpingId());
            Customer customer = customerDAOService.getCustomerDetailsById(customerorder.getCustomerId());

            CustomerOrderDetails customerOrderDetails = new CustomerOrderDetails();

            customerOrderDetails.setCustomerOrderId(customerorder.getOrderId());
            customerOrderDetails.setCustomerId(customerorder.getCustomerId());
            customerOrderDetails.setCustomerName(customer.getName());
            customerOrderDetails.setOrderdate(customerorder.getOrderdate());
            customerOrderDetails.setStatus(customerorder.getStatus());
            customerOrderDetails.setFuelType(customerorder.getFuelType());
            customerOrderDetails.setVolume(customerorder.getVolume());
            customerOrderDetails.setRate(customerorder.getRate());

            customerOrderDetails.setPumpingDetails(pumpingDetail);

            customerOrderDetailsList.add(customerOrderDetails);
        }
        ResponseMessage responseMessage = null;
        if (customerOrderDetailsList != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(customerOrderDetailsList);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(customerOrderDetailsList);
        }
        return responseMessage;
    }

    /**
     *
     * viewCustomerOrderDetailsByOrderId
     *
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "viewCustomerOrderDetailsByOrderId", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage viewCustomerOrderDetailsByOrderId(@RequestParam("orderId")Long orderId) {

        Customerorder customerorder = customerOrderDAOService.getCustomerOrder(orderId);
        ResponseMessage responseMessage = null;
        if (customerorder != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(customerorder);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(customerorder);
        }
        return responseMessage;
    }


    /**
     *
     * incomingRequestNotApprovedCount
     *
     * @return
     */
    @RequestMapping(value = "incomingRequestNotApprovedCount", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage incomingRequestNotApprovedCount() {
        double res = customerOrderDAOService.incomingRequestNotAprovedCount();
        ResponseMessage responseMessage = null;
        if (res != 0) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }


    /**
     *
     * todayApprovedRequestCount
     *
     * @return
     */
    @RequestMapping(value = "todayApprovedRequestCount", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage todayApprovedRequestCount() {
        double res = customerOrderDAOService.todayApprovedRequestCount();
        ResponseMessage responseMessage = null;
        if (res != 0) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    /**
     *
     * getTodayRequestOrderCount
     *
     * @return
     */
    @RequestMapping(value = "getTodayRequestOrderCount", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage getTodayRequestOrderCount() {
        List<Customerorder> list = customerOrderDAOService.dailyRequestDetails();
        int res = list.size();
        ResponseMessage responseMessage = null;
        if (res != 0) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    /**
     *
     * getApprovedRequestOrderCountByUserId
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "getApprovedRequestOrderCountByUserId", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage getApprovedRequestOrderCountByUserId(@RequestParam("userId")Long userId) {
        List<Customerorder> list  = customerOrderDAOService.getApprovedRequestOrderCountByUserId(userId);

        int res = list.size();
        ResponseMessage responseMessage = null;
        if (res != 0) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }





    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public Customerorder getob() {
        return new Customerorder();
    }


}
