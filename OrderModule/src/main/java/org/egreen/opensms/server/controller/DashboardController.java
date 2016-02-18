package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.Customerorder;
import org.egreen.opensms.server.models.FuelChartArrayModel;
import org.egreen.opensms.server.models.FuelChartDailyModel;
import org.egreen.opensms.server.models.FuelChartModel;
import org.egreen.opensms.server.service.CustomerOrderDAOService;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by pramoda-nf on 5/12/15.
 */


@Controller
@RequestMapping("fmms/dashboard")
public class DashboardController {


    @Autowired
    private CustomerOrderDAOService customerOrderDAOService;

    /**
     *
     * Dashboard Fuel Chart
     *
     * @return
     */
    @RequestMapping(value = "dashboardFuelChart", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage dashboardFuelChart() {

        Map<String, Double> fuelList = new HashMap<String, Double>();


        ArrayList<String>fueltypeList =  new ArrayList<String>();
        ArrayList<String>dateList =  new ArrayList<String>();
        ArrayList<Double>amountList =  new ArrayList<Double>();

        List<FuelChartModel> dieselList = customerOrderDAOService.detailChart();
        for (FuelChartModel fuelChartModel : dieselList) {
            fueltypeList.add(fuelChartModel.getFuelType());
        }

        for (FuelChartModel fuelChartModel : dieselList) {
           fuelList.put(fuelChartModel.getOrderdate(),fuelChartModel.getVolume());
        }

        Set<String> keys = fuelList.keySet();
        for(String key: keys){
            dateList.add(key);


            Double aDouble = fuelList.get(key);
            amountList.add(aDouble);
        }

        FuelChartArrayModel fuelChartArrayModel =new FuelChartArrayModel();

        fuelChartArrayModel.setFueltype(fueltypeList);
        fuelChartArrayModel.setAmountlist(amountList);
        fuelChartArrayModel.setDatelist(dateList);


        ResponseMessage responseMessage = null;
        if (fuelChartArrayModel != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(fuelChartArrayModel);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(fuelChartArrayModel);
        }
        return responseMessage;
    }

    /**
     *
     * Dashboard FuelChart By Daily
     *
     *
     * @return
     */
    @RequestMapping(value = "dashboardFuelChartByDaily", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage dashboardFuelChartByDaily() {

        ArrayList<String>fueltype =  new ArrayList<String>();
        fueltype.add("DIESEL");
        fueltype.add("LUBRE");
        fueltype.add("PETROL");


        ArrayList<String>dateList =  new ArrayList<String>();

        ArrayList<ArrayList<Double>>amountList =  new ArrayList<ArrayList<Double>>();
        ArrayList<Double>dielselList =  new ArrayList<Double>();
        ArrayList<Double>petrolList =  new ArrayList<Double>();
        ArrayList<Double>lubreList =  new ArrayList<Double>();

        List<FuelChartModel> dieselList = customerOrderDAOService.dashboardFuelChartByDaily();
        for (FuelChartModel fuelChartModel : dieselList) {

            dateList.add(fuelChartModel.getOrderdate());

            if (fuelChartModel.getFuelType().equals("DIESEL")){
                dielselList.add(fuelChartModel.getVolume());

            }else if (fuelChartModel.getFuelType().equals("LUBRE")){
                lubreList.add(fuelChartModel.getVolume());

            }else{
                petrolList.add(fuelChartModel.getVolume());

            }
        }

        amountList.add(dielselList);
        amountList.add(petrolList);
        amountList.add(lubreList);



        FuelChartDailyModel fuelChartDailyModel =  new FuelChartDailyModel();
        fuelChartDailyModel.setFuelType(fueltype);
        fuelChartDailyModel.setDateList(dateList);
        fuelChartDailyModel.setAmountList(amountList);



        ResponseMessage responseMessage = null;
        if (fuelChartDailyModel != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(fuelChartDailyModel);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(fuelChartDailyModel);
        }
        return responseMessage;

    }


}
