package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.Pumpingtype;
import org.egreen.opensms.server.service.PumpingTypeDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by dewmal on 7/17/14.
 */
@Controller
@RequestMapping("fmms/pumping_type")
public class PumpingTypeController {

    @Autowired
    private PumpingTypeDAOService pumpingTypeDAOService;

    /**
     *
     * User SignUp
     *
     * @param pumpingtype
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage save(@RequestBody Pumpingtype pumpingtype) {
        Long res = pumpingTypeDAOService.save(pumpingtype);
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
     * Get All Pumping Types
     *
     * @return
     */
    @RequestMapping(value = "getAllPumpingTypes", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage getAllPumpingTypes() {

       List<Pumpingtype> res =  pumpingTypeDAOService.getAllPumpingTypes();
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
    public Pumpingtype getob() {
        return new Pumpingtype();
    }

}
