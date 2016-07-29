package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.StockPumpingDetails;
import org.egreen.opensms.server.service.StockDetailsDAOService;
import org.egreen.opensms.server.service.StockPumpingDetailsDAOService;
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
@RequestMapping("fmms/admin/stockpumpingdetails")
public class StockPumpingDetailsController {

    @Autowired
    private StockPumpingDetailsDAOService stockpumpingdetailsdaoservice;

    /**
     *
     * User save
     *
     * @param stockpumpingdetails
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage save(@RequestBody StockPumpingDetails stockpumpingdetails) {
        Long res = stockpumpingdetailsdaoservice.save(stockpumpingdetails);
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
    public StockPumpingDetails getob() {
        return new StockPumpingDetails();
    }


    /***
     *
     * getAllPumpingDetails
     *
     *
     * @return
     */
    @RequestMapping(value = "getAllPumpingDetails", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage getAllPumpingDetails() {

        List<StockPumpingDetails> res = stockpumpingdetailsdaoservice.getAllPumpingDetails();
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


}
