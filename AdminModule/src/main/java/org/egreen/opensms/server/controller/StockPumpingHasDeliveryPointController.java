package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.StockPumpingDetails;
import org.egreen.opensms.server.entity.StockPumpingHasDeliveryPoint;
import org.egreen.opensms.server.service.StockPumpingDetailsDAOService;
import org.egreen.opensms.server.service.StockPumpingHasDeliveryPointDAOService;
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
@RequestMapping("fmms/admin/stockpumpinghasdelivery")
public class StockPumpingHasDeliveryPointController {

    @Autowired
    private StockPumpingHasDeliveryPointDAOService stockPumpingHasDeliveryPointDAOService;

    /**
     *
     * User save
     *
     * @param stockPumpingHasDeliveryPoint
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage save(@RequestBody StockPumpingHasDeliveryPoint stockPumpingHasDeliveryPoint) {
        Long res = stockPumpingHasDeliveryPointDAOService.save(stockPumpingHasDeliveryPoint);
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
    public StockPumpingHasDeliveryPoint getob() {
        return new StockPumpingHasDeliveryPoint();
    }


    /**
     *
     * getAllPumpingHasDeliveryPoint
     *
     * @return
     */
    @RequestMapping(value = "getAllPumpingHasDeliveryPoint", method = RequestMethod.GET)
    @ResponseBody
    public List<StockPumpingHasDeliveryPoint> getAllPumpingHasDeliveryPoint() {

        return stockPumpingHasDeliveryPointDAOService.getAllPumpingHasDeliveryPoint();
    }


}
