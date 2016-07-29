package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.Customerorder;
import org.egreen.opensms.server.entity.CustomerorderPK;
import org.egreen.opensms.server.service.CustomerOrderDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pramoda-nf on 5/8/15.
 */

@Controller
@RequestMapping("fmms/orderprocess")
public class OrderProcessController {

    @Autowired
    private CustomerOrderDAOService customerOrderDAOService;


    /**
     *
     * approve By Sales Manager
     *
     * @param customerOrderId
     * @param rate
     * @return
     */
    @RequestMapping(value = "approveBySalesManager", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage approveBySalesManager(@RequestParam("customerOrderId") Long customerOrderId,@RequestParam("rate") Double rate) {
        CustomerorderPK res = customerOrderDAOService.approveBySalesManager(customerOrderId, rate);
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
     * get Approval By Store Manager
     *
     *
     * @param customerOrderId
     * @return
     */
    @RequestMapping(value = "getApprovalByStoreManager", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage getApprovalByStoreManager(@RequestParam("customerOrderId") Long customerOrderId) {
        CustomerorderPK res = customerOrderDAOService.getApprovalByStoreManager(customerOrderId);
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
     * approve By Store Manager
     *
     *
     * @param customerOrderId
     * @param userId
     * @return
     */
    @RequestMapping(value = "approveByStoreManager", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage approveByStoreManager(@RequestParam("customerOrderId") Long customerOrderId,@RequestParam("userId") Long userId) {
        CustomerorderPK res = customerOrderDAOService.approveByStoreManager(customerOrderId,userId);

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



    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public Customerorder getob() {
        return new Customerorder();
    }

}
