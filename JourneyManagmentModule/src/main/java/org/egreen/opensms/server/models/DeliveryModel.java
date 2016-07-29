package org.egreen.opensms.server.models;

import org.egreen.opensms.server.entity.DeliveryPoint;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Pramoda Fernando on 4/8/2015.
 */
public class DeliveryModel {

    private Long customerOrderId;
    private String customerName;
    private String fuelType;
    private BigDecimal volume;
    private Timestamp orderDate;
    private DeliveryPointModel deliveryPointModel;


    public Long getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(Long customerOrderId) {
        this.customerOrderId = customerOrderId;
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

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public DeliveryPointModel getDeliveryPointModel() {
        return deliveryPointModel;
    }

    public void setDeliveryPointModel(DeliveryPointModel deliveryPointModel) {
        this.deliveryPointModel = deliveryPointModel;
    }
}
