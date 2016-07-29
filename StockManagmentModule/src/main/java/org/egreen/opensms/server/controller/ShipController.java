package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.Ship;
import org.egreen.opensms.server.service.ShipDAOService;
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
@RequestMapping("fmms/ship")
public class ShipController {

    @Autowired
    private ShipDAOService shipDAOService;


    /**
     *
     * Save Ship
     *
     * @param ship
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage save(@RequestBody Ship ship){

        String res = shipDAOService.save(ship);

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
    public Ship getob() {
        return new Ship();
    }


}
