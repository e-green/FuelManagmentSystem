package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.Barge;

import org.egreen.opensms.server.entity.CompatmentHasStockPumpingDetails;
import org.egreen.opensms.server.entity.CompatmentHasStockPumpingDetailsPK;
import org.egreen.opensms.server.service.BargeDAOService;
import org.egreen.opensms.server.service.CompatmentHasPumpDAOService;
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
@RequestMapping("fmms/compatment_has_pump")
public class CompatmentHasPumpController {

    @Autowired
    private CompatmentHasPumpDAOService compatmentHasPumpDAOService;


    /**
     *
     * Save  Compatment Has Stock Pumping Details
     *
     * @param compatmentHasPump
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage save(@RequestBody CompatmentHasStockPumpingDetails compatmentHasPump) {
        CompatmentHasStockPumpingDetailsPK res = compatmentHasPumpDAOService.save(compatmentHasPump);
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
    public CompatmentHasStockPumpingDetails getob() {
        return new CompatmentHasStockPumpingDetails();
    }


}
