package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.Barge;
import org.egreen.opensms.server.entity.Bowser;
import org.egreen.opensms.server.entity.Compatment;
import org.egreen.opensms.server.service.BowserDAOService;
import org.egreen.opensms.server.service.CompatmentDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by dewmal on 7/17/14.
 */
@Controller
@RequestMapping("fmms/compatment")
public class CompatmentController {

    @Autowired
    private CompatmentDAOService compatmentDAOService;


    /**
     *
     * Save Compatment
     *
     *
     * @param compatment
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage save(@RequestBody Compatment compatment) {
        String res = compatmentDAOService.save(compatment);
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
     * getAllComDetailByContainerId
     *
     * @param containerId
     * @return
     */
    @RequestMapping(value = "getAllComDetailByContainerId", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage getAllComDetailByContainerId(@RequestParam("containerId")String containerId) {
       List<Compatment> res =  compatmentDAOService.getAllCompatmentByBargeId(containerId) ;
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
    public Compatment getob() {
        return new Compatment();
    }


}
