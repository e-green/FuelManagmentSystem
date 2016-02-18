package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.Stockdetails;
import org.egreen.opensms.server.service.StockDetailsDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by dewmal on 7/17/14.
 */
@Controller
@RequestMapping("fmms/admin/stockdetails")
public class StockDetailsController {

    @Autowired
    private StockDetailsDAOService stockdetailsdaoservice;


    /**
     *
     * User save
     *
     * @param stockdetails
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage signup(@RequestBody Stockdetails stockdetails) {
        Long res = stockdetailsdaoservice.save(stockdetails);
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


/////////                                                                                                       ////////
///////////////////////////////////////////////////GET CONTROLLERS//////////////////////////////////////////////////////
/////////                                                                                                       ////////


    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public Stockdetails getob() {
        return new Stockdetails();
    }


}
