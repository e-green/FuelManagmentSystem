package org.egreen.opensms.server.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */
@Entity
@Table(name = "delivery_point")
@IdClass(DeliveryPointPK.class)
public class DeliveryPoint implements EntityInterface <DeliveryPointPK>{

    private long detailsId;
    private long customerId;
    private String addressline1;
    private String addressline2;
    private String city;
    private String label;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String pumpingType;

    @Id
    @Column(name = "details_id")
    public long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(long detailsId) {
        this.detailsId = detailsId;
    }

    @Id
    @Column(name = "customer_id")
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "addressline1")
    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    @Basic
    @Column(name = "addressline2")
    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic
    @Column(name = "latitude")
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude")
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "pumping_type")
    public String getPumpingType() {
        return pumpingType;
    }

    public void setPumpingType(String pumpingType) {
        this.pumpingType = pumpingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryPoint that = (DeliveryPoint) o;

        if (customerId != that.customerId) return false;
        if (detailsId != that.detailsId) return false;
        if (addressline1 != null ? !addressline1.equals(that.addressline1) : that.addressline1 != null) return false;
        if (addressline2 != null ? !addressline2.equals(that.addressline2) : that.addressline2 != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (pumpingType != null ? !pumpingType.equals(that.pumpingType) : that.pumpingType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (detailsId ^ (detailsId >>> 32));
        result = 31 * result + (int) (customerId ^ (customerId >>> 32));
        result = 31 * result + (addressline1 != null ? addressline1.hashCode() : 0);
        result = 31 * result + (addressline2 != null ? addressline2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (pumpingType != null ? pumpingType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeliveryPoint{" +
                "detailsId=" + detailsId +
                ", customerId=" + customerId +
                ", addressline1='" + addressline1 + '\'' +
                ", addressline2='" + addressline2 + '\'' +
                ", city='" + city + '\'' +
                ", label='" + label + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", pumpingType='" + pumpingType + '\'' +
                '}';
    }

    @Override
    @Transient
    public DeliveryPointPK getId() {
        return new DeliveryPointPK(getDetailsId(),getCustomerId());
    }

}
