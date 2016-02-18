package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.Tank;
import org.egreen.opensms.server.service.TankDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dewmal on 7/17/14.
 */
@Controller
@RequestMapping("fmms/tank")
public class TankController {

    @Autowired
    private TankDAOService tankDAOService;


    /**
     *
     * Save Tank
     *
     * @param tank
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage save(@RequestBody Tank tank){

        String res = tankDAOService.save(tank);

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
    public Tank getob() {
        return new Tank();
    }


}
