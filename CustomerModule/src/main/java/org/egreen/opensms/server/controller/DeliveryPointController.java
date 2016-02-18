package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.DeliveryPoint;
import org.egreen.opensms.server.entity.DeliveryPointPK;
import org.egreen.opensms.server.service.DeliveryPointDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * Created by dewmal on 7/17/14.
 */

@Controller
@RequestMapping("fmms/delivery_details")
public class DeliveryPointController {

    @Autowired
    private DeliveryPointDAOService deliveryPointDAOService;

    /**
     *
     * User SignUp
     *
     * @param deliveryPoint
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage save(@RequestBody DeliveryPoint deliveryPoint) {
        DeliveryPointPK res = deliveryPointDAOService.save(deliveryPoint);
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
     * getPumpingDetailsByCustomerId
     *
     *
     * @param customerId
     * @return
     */
    @RequestMapping(value = "getPumpingDetailsByCustomerId", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage getPumpingDetailsByCustomerId(@RequestParam("customerId")Long customerId) {
       List<DeliveryPoint> res =  deliveryPointDAOService.getPumpingDetailsByCustomerId(customerId);
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
    public DeliveryPoint getob() {
        return new DeliveryPoint();
    }

}
