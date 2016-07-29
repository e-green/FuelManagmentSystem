package org.egreen.opensms.server.models;

import org.egreen.opensms.server.entity.Customerorder;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by pramoda-nf on 5/15/15.
 */
public class FuelChartArrayModel {

    List<String> fueltype;
    List<String> datelist;
    List<Double> amountlist ;

    public List<String> getFueltype() {
        return fueltype;
    }

    public void setFueltype(List<String> fueltype) {
        this.fueltype = fueltype;
    }

    public List<String> getDatelist() {
        return datelist;
    }

    public void setDatelist(List<String> datelist) {
        this.datelist = datelist;
    }

    public List<Double> getAmountlist() {
        return amountlist;
    }

    public void setAmountlist(List<Double> amountlist) {
        this.amountlist = amountlist;
    }
}
