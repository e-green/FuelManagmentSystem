package org.egreen.opensms.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Pramoda Fernando on 4/21/2015.
 */
@Entity
@Table(name = "journeyorder")
@JsonIgnoreProperties
public class JourneyOrder implements EntityInterface<Long> {
    private Long journeyid;
    private Long companyOrderId;
    private Long customerOrderId;
    private String customerName;
    private String fuelType;
    private BigDecimal volume;
    private Timestamp orderDate;
    private String addressline1;
    private String addressline2;
    private String city;
    private String label;
    private String latitude;
    private String longitude;


    @Id
    @Column(name = "journey_id")
    public Long getJourneyid() {
        return journeyid;
    }

    public void setJourneyid(Long journeyid) {
        this.journeyid = journeyid;
    }


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(Long customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public Long getCompanyOrderId() {
        return companyOrderId;
    }

    public void setCompanyOrderId(Long companyOrderId) {
        this.companyOrderId = companyOrderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JourneyOrder that = (JourneyOrder) o;

        if (addressline1 != null ? !addressline1.equals(that.addressline1) : that.addressline1 != null) return false;
        if (addressline2 != null ? !addressline2.equals(that.addressline2) : that.addressline2 != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (companyOrderId != null ? !companyOrderId.equals(that.companyOrderId) : that.companyOrderId != null)
            return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        if (customerOrderId != null ? !customerOrderId.equals(that.customerOrderId) : that.customerOrderId != null)
            return false;
        if (fuelType != null ? !fuelType.equals(that.fuelType) : that.fuelType != null) return false;
        if (journeyid != null ? !journeyid.equals(that.journeyid) : that.journeyid != null) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = journeyid != null ? journeyid.hashCode() : 0;
        result = 31 * result + (companyOrderId != null ? companyOrderId.hashCode() : 0);
        result = 31 * result + (customerOrderId != null ? customerOrderId.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (fuelType != null ? fuelType.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (addressline1 != null ? addressline1.hashCode() : 0);
        result = 31 * result + (addressline2 != null ? addressline2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }

    @Override
    @Transient
    public Long getId() {
        return getJourneyid();
    }


    @Override
    public String toString() {
        return "JourneyOrder{" +
                "journeyid=" + journeyid +
                ", companyOrderId=" + companyOrderId +
                ", customerOrderId=" + customerOrderId +
                ", customerName='" + customerName + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", volume=" + volume +
                ", orderDate=" + orderDate +
                ", addressline1='" + addressline1 + '\'' +
                ", addressline2='" + addressline2 + '\'' +
                ", city='" + city + '\'' +
                ", label='" + label + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
