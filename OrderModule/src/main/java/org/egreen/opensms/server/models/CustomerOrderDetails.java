package org.egreen.opensms.server.models;

import org.egreen.opensms.server.entity.DeliveryPoint;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Pramoda Fernando on 4/6/2015.
 */
public class CustomerOrderDetails  {

    private long customerOrderId;
    private long customerId;
    private String customerName;
    private String fuelType;
    private BigDecimal volume;
    private boolean status;
    private Timestamp orderdate;
    private BigDecimal rate;
    private String storeManagerAproval;

    private DeliveryPoint pumpingDetails;

    public long getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(long customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Timestamp orderdate) {
        this.orderdate = orderdate;
    }

    public DeliveryPoint getPumpingDetails() {
        return pumpingDetails;
    }

    public void setPumpingDetails(DeliveryPoint pumpingDetails) {
        this.pumpingDetails = pumpingDetails;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;


    }

    public String getStoreManagerAproval() {
        return storeManagerAproval;
    }

    public void setStoreManagerAproval(String storeManagerAproval) {
        this.storeManagerAproval = storeManagerAproval;
    }
}
