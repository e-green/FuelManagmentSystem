package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.Barge;
import org.egreen.opensms.server.service.BargeDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by dewmal on 7/17/14.
 */
@Controller
@RequestMapping("fmms/barge")
public class BargeController {

    @Autowired
    private BargeDAOService  bargeDAOService;


    /**
     * 
     * Save Barge Controller
     *
     * @param barge
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage save(@RequestBody Barge barge) {

        String res = bargeDAOService.save(barge);

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
     * getAllBarges
     *
     * @return
     */
    @RequestMapping(value = "getAllBarges", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage getAllBarges() {
        List<Barge> res = bargeDAOService.getAllBarges();


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
    public Barge getob() {
        return new Barge();
    }


}
