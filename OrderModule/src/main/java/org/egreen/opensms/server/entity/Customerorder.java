package org.egreen.opensms.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Pramoda Fernando on 3/20/2015.
 */
@Entity
@Table(name = "customerorder")
@IdClass(CustomerorderPK.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customerorder implements EntityInterface <CustomerorderPK> {
    private long orderId;
    private long customerId;
    private long pumpingId;
    private String fuelType;
    private BigDecimal volume;
    private String note;
    private boolean status;
    private Timestamp orderdate;
    private BigDecimal rate;
    private String storeManagerAproval;
    private Timestamp approvedDate;
    private Long approvedBy;


    @Id
    @Column(name = "orderId")
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "customer_id")
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Id
    @Column(name = "pumping_id")
    public long getPumpingId() {
        return pumpingId;
    }

    public void setPumpingId(long pumpingId) {
        this.pumpingId = pumpingId;
    }

    @Basic
    @Column(name = "fuel_type")
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Basic
    @Column(name = "volume")
    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "status")
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "orderdate")
    public Timestamp getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Timestamp orderdate) {
        this.orderdate = orderdate;
    }

    @Basic
    @Column(name = "rate")
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "storeManagerAproval")
    public String getStoreManagerAproval() {
        return storeManagerAproval;
    }

    public void setStoreManagerAproval(String storeManagerAproval) {
        this.storeManagerAproval = storeManagerAproval;
    }

    @Basic
    @Column(name = "approvedDate")
    public Timestamp getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Timestamp approvedDate) {
        this.approvedDate = approvedDate;
    }

    @Basic
    @Column(name = "approvedBy")
    public Long getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Long approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customerorder that = (Customerorder) o;

        if (customerId != that.customerId) return false;
        if (orderId != that.orderId) return false;
        if (pumpingId != that.pumpingId) return false;
        if (status != that.status) return false;
        if (approvedBy != null ? !approvedBy.equals(that.approvedBy) : that.approvedBy != null) return false;
        if (approvedDate != null ? !approvedDate.equals(that.approvedDate) : that.approvedDate != null) return false;
        if (fuelType != null ? !fuelType.equals(that.fuelType) : that.fuelType != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (orderdate != null ? !orderdate.equals(that.orderdate) : that.orderdate != null) return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;
        if (storeManagerAproval != null ? !storeManagerAproval.equals(that.storeManagerAproval) : that.storeManagerAproval != null)
            return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (int) (customerId ^ (customerId >>> 32));
        result = 31 * result + (int) (pumpingId ^ (pumpingId >>> 32));
        result = 31 * result + (fuelType != null ? fuelType.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + (orderdate != null ? orderdate.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (storeManagerAproval != null ? storeManagerAproval.hashCode() : 0);
        result = 31 * result + (approvedDate != null ? approvedDate.hashCode() : 0);
        result = 31 * result + (approvedBy != null ? approvedBy.hashCode() : 0);
        return result;
    }

    @Override
    @Transient
    public CustomerorderPK getId() {
        return new CustomerorderPK(getOrderId(),getCustomerId(),getPumpingId());
    }

    @Override
    public String toString() {
        return "Customerorder{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", pumpingId=" + pumpingId +
                ", fuelType='" + fuelType + '\'' +
                ", volume=" + volume +
                ", note='" + note + '\'' +
                ", status=" + status +
                ", orderdate=" + orderdate +
                ", rate=" + rate +
                ", storeManagerAproval='" + storeManagerAproval + '\'' +
                ", approvedDate=" + approvedDate +
                ", approvedBy=" + approvedBy +
                '}';
    }
}
