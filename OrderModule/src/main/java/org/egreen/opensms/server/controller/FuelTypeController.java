package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.Fueltype;
import org.egreen.opensms.server.service.FuelTypeDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */

@Controller
@RequestMapping("fmms/fuel_type")
public class FuelTypeController {

    @Autowired
    private FuelTypeDAOService fuelTypeDAOService;

    /**
     *
     * Save Fuel Type
     *
     * @param fueltype
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage save(@RequestBody Fueltype fueltype) {
        Long res = fuelTypeDAOService.save(fueltype);
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
     * getAllFueltype
     *
     * @return
     */
    @RequestMapping(value = "getAllFueltype", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage getAllFueltype() {

       List<Fueltype> res =  fuelTypeDAOService.getAllFueltype();
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
     * getAllFueltypeByID
     *
     * @param fueltypeId
     * @return
     */
    @RequestMapping(value = "getAllFueltypeByID", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage getAllFueltypeByID(@RequestParam("fueltypeId")Long fueltypeId) {

        Fueltype res =  fuelTypeDAOService.getAllFueltypeByID(fueltypeId);
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
    public Fueltype getob() {
        return new Fueltype();
    }





}
