package org.egreen.opensms.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Pramoda Fernando on 3/19/2015.
 */
@Entity
@Table(name = "stockdetails")
@JsonIgnoreProperties
public class Stockdetails implements EntityInterface <Long> {
    private long stockdetailsid;
    private String type;
    private BigDecimal capacity;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private BigDecimal preorderLevel;
    private long spDetailsid;

    private Timestamp status_time;
    private String status_type;
    private BigDecimal watercontent;

    private BigDecimal fuel_level;
    private BigDecimal temperature;
    private BigDecimal pressure;
    private String emg_signal;
    private String leakage;


    @Id
    @Column(name = "stockdetailsid")
    public long getStockdetailsid() {
        return stockdetailsid;
    }

    public void setStockdetailsid(long stockdetailsid) {
        this.stockdetailsid = stockdetailsid;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "capacity")
    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
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
    @Column(name = "latitude")
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "preorder_level")
    public BigDecimal getPreorderLevel() {
        return preorderLevel;
    }

    public void setPreorderLevel(BigDecimal preorderLevel) {
        this.preorderLevel = preorderLevel;
    }

    @Basic
    @Column(name = "sp_detailsid")
    public long getSpDetailsid() {
        return spDetailsid;
    }

    public void setSpDetailsid(long spDetailsid) {
        this.spDetailsid = spDetailsid;
    }

    @Basic
    @Column(name = "status_time")
    public Timestamp getStatus_time() {
        return status_time;
    }

    public void setStatus_time(Timestamp status_time) {
        this.status_time = status_time;
    }

    @Basic
    @Column(name = "status_type")
    public String getStatus_type() {
        return status_type;
    }

    public void setStatus_type(String status_type) {
        this.status_type = status_type;
    }

    @Basic
    @Column(name = "watercontent")
    public BigDecimal getWatercontent() {
        return watercontent;
    }

    public void setWatercontent(BigDecimal watercontent) {
        this.watercontent = watercontent;
    }

    @Basic
    @Column(name = "fuel_level")
    public BigDecimal getFuel_level() {
        return fuel_level;
    }

    public void setFuel_level(BigDecimal fuel_level) {
        this.fuel_level = fuel_level;
    }

    @Basic
    @Column(name = "temperature")
    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    @Basic
    @Column(name = "pressure")
    public BigDecimal getPressure() {
        return pressure;
    }

    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    @Basic
    @Column(name = "emg_signal")
    public String getEmg_signal() {
        return emg_signal;
    }

    public void setEmg_signal(String emg_signal) {
        this.emg_signal = emg_signal;
    }

    @Basic
    @Column(name = "leakage")
    public String getLeakage() {
        return leakage;
    }

    public void setLeakage(String leakage) {
        this.leakage = leakage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stockdetails that = (Stockdetails) o;

        if (spDetailsid != that.spDetailsid) return false;
        if (stockdetailsid != that.stockdetailsid) return false;
        if (capacity != null ? !capacity.equals(that.capacity) : that.capacity != null) return false;
        if (emg_signal != null ? !emg_signal.equals(that.emg_signal) : that.emg_signal != null) return false;
        if (fuel_level != null ? !fuel_level.equals(that.fuel_level) : that.fuel_level != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (leakage != null ? !leakage.equals(that.leakage) : that.leakage != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (preorderLevel != null ? !preorderLevel.equals(that.preorderLevel) : that.preorderLevel != null)
            return false;
        if (pressure != null ? !pressure.equals(that.pressure) : that.pressure != null) return false;
        if (status_time != null ? !status_time.equals(that.status_time) : that.status_time != null) return false;
        if (status_type != null ? !status_type.equals(that.status_type) : that.status_type != null) return false;
        if (temperature != null ? !temperature.equals(that.temperature) : that.temperature != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (watercontent != null ? !watercontent.equals(that.watercontent) : that.watercontent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (stockdetailsid ^ (stockdetailsid >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (preorderLevel != null ? preorderLevel.hashCode() : 0);
        result = 31 * result + (int) (spDetailsid ^ (spDetailsid >>> 32));
        result = 31 * result + (status_time != null ? status_time.hashCode() : 0);
        result = 31 * result + (status_type != null ? status_type.hashCode() : 0);
        result = 31 * result + (watercontent != null ? watercontent.hashCode() : 0);
        result = 31 * result + (fuel_level != null ? fuel_level.hashCode() : 0);
        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
        result = 31 * result + (pressure != null ? pressure.hashCode() : 0);
        result = 31 * result + (emg_signal != null ? emg_signal.hashCode() : 0);
        result = 31 * result + (leakage != null ? leakage.hashCode() : 0);
        return result;
    }

    @Override
    @Transient
    public Long getId() {
        return getStockdetailsid();
    }

    @Override
    public String toString() {
        return "Stockdetails{" +
                "stockdetailsid=" + stockdetailsid +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", preorderLevel=" + preorderLevel +
                ", spDetailsid=" + spDetailsid +
                ", status_time=" + status_time +
                ", status_type='" + status_type + '\'' +
                ", watercontent=" + watercontent +
                ", fuel_level=" + fuel_level +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", emg_signal='" + emg_signal + '\'' +
                ", leakage='" + leakage + '\'' +
                '}';
    }
}
