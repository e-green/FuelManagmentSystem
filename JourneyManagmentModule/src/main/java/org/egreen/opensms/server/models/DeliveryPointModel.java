package org.egreen.opensms.server.models;

import org.egreen.opensms.server.entity.StockPumpingDetails;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Pramoda Fernando on 4/8/2015.
 */
public class DeliveryPointModel {

    private long detailsId;
    private long customerId;
    private String addressline1;
    private String addressline2;
    private String city;
    private String label;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private List<StockPumpingDetails> stockPumpingDetails;

    public long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(long detailsId) {
        this.detailsId = detailsId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public List<StockPumpingDetails> getStockPumpingDetails() {
        return stockPumpingDetails;
    }

    public void setStockPumpingDetails(List<StockPumpingDetails> stockPumpingDetails) {
        this.stockPumpingDetails = stockPumpingDetails;
    }
}
