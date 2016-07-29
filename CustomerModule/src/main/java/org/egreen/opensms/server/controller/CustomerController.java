package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.Customer;
import org.egreen.opensms.server.service.CustomerDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by dewmal on 7/17/14.
 */
@Controller
@RequestMapping("fmms/customer")
public class CustomerController {

    @Autowired
    private CustomerDAOService customerDAOService;

    /**
     *
     * User SignUp
     *
     * @param customer
     * @return
     */
    @RequestMapping(value = "customer_register", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage register_customer(@RequestBody Customer customer) {
        Long res = customerDAOService.register_customer(customer);
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
     * User Update
     *
     * @param customer
     * @return
     */
    @RequestMapping(value = "update_customer", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage edit_customer(@RequestBody Customer customer) {
        Long res = customerDAOService.edit_Customer(customer);
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


/////////                                                                                                      /////////
///////////////////////////////////////////////////GET CONTROLLERS//////////////////////////////////////////////////////
/////////                                                                                                      /////////

    /**
     *
     * User Login
     *
     * @param customername
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage login(@RequestParam("customername") String customername, @RequestParam("password") String password) {
        Customer res = customerDAOService.login(customername, password);
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
     * Check Email Validity
     *
     * @param email
     * @return
     */
    @RequestMapping(value = "check_email_validity", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage check_email_validity(@RequestParam("email") String email) {
        Integer res = customerDAOService.check_email_validity(email);
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
     * Replace New Password
     *
     *
     * @return
     */
//    @RequestMapping(value = "reset_password", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseMessage reset_password(@RequestParam("email") String email) {
//        Integer res = customerDAOService.reset_password(email);
//        ResponseMessage responseMessage;
//        if(res != null){
//            responseMessage = ResponseMessage.SUCCESS;
//            responseMessage.setData(res);
//        }else{
//            responseMessage = ResponseMessage.DANGER;
//            responseMessage.setData(res);
//        }
//        return responseMessage;
//    }


    /**
     *
     * Get All Customer Detail
     *
     * @return
     */
    @RequestMapping(value = "get_all_customer_details", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage get_all_customer_details() {
        List<Customer> res = customerDAOService.get_all_customer_details();
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
     * Get All Not approve Customers
     *
     * @return
     */
    @RequestMapping(value = "getAllNotApprovedCustomers", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage getAllNotApprovedCustomers() {
        List<Customer> res = customerDAOService.getAllNotApprovedCustomers();
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
     * Update Customer Status
     *
     * @param customer_id
     * @return
     */
    @RequestMapping(value = "updateCustomerStatus", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage updateCustomerStatus(@RequestParam("customer_id") Long customer_id) {
        Long res = customerDAOService.updateCustomerStatus(customer_id);
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
     * get Customer Details By Id
     *
     * @param customer_id
     * @return ResponseMessage(Customer)
     */
    @RequestMapping(value = "getCustomerDetailsById", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage getCustomerDetailsById(@RequestParam("customer_id") Long customer_id) {
        Customer res = customerDAOService.getCustomerDetailsById(customer_id);
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
     * Get All User Details By User Id
     *
//   * @param customerId
     * @return
     */
//    @RequestMapping(value = "get_all_customer_details_by_customerId", method = RequestMethod.POST)
//    @ResponseBody
//    public User get_all_details_byUserId(@RequestParam("customerId") Long customerId) {
//        User res = customerDAOService.get_all_details_byUserId(customerId);
//        return res;
//    }

    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public Customer getob() {
        return new Customer();
    }


    @RequestMapping(value ="deleteCustomerById", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public Integer deleteCustomerById(@RequestParam("customerId") String customerId){

        Integer res=customerDAOService.deleteCustomerById(customerId);
        return res;
    }

}
