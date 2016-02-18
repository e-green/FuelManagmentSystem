package org.egreen.opensms.server.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by pramoda-nf on 5/15/15.
 */
public class FuelChartModel {

    private String fuelType;
    private Double volume;
    private String orderdate;

    public FuelChartModel() {
    }

    public FuelChartModel(String fuelType, Double volume, String orderdate) {
        this.fuelType = fuelType;
        this.volume = volume;
        this.orderdate = orderdate;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }
}
