package org.egreen.opensms.server.models;

import java.util.ArrayList;

/**
 * Created by pramoda-nf on 5/21/15.
 */
public class FuelChartDailyModel {

    ArrayList<String>fuelType;
    ArrayList<String>dateList;
    ArrayList<ArrayList<Double>>amountList;

    public ArrayList<String> getFuelType() {
        return fuelType;
    }

    public void setFuelType(ArrayList<String> fuelType) {
        this.fuelType = fuelType;
    }

    public ArrayList<String> getDateList() {
        return dateList;
    }

    public void setDateList(ArrayList<String> dateList) {
        this.dateList = dateList;
    }

    public ArrayList<ArrayList<Double>> getAmountList() {
        return amountList;
    }

    public void setAmountList(ArrayList<ArrayList<Double>> amountList) {
        this.amountList = amountList;
    }
}
