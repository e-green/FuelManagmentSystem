package org.egreen.opensms.server.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by pramoda-nf on 5/19/15.
 */
@Entity
@Table(name = "grabberdetails")
public class GrabberDetails implements EntityInterface<Long> {
    private long stockdetailsid;
    private BigDecimal capacity;
    private String emgSignal;
    private BigDecimal fuelLevel;
    private BigDecimal latitude;
    private String leakage;
    private BigDecimal longitude;
    private BigDecimal preorderLevel;
    private BigDecimal pressure;
    private String storageDetailsid;
    private Timestamp statusTime;
    private String statusType;
    private BigDecimal temperature;
    private String type;
    private BigDecimal watercontent;

    private String nodeID;
    private String messageID;
    private String gsm;
    private String gprs;
    private String satellite;
    private String wifi;
    private String bluetooth;
    private String gps;
    private String emergency;
    private String reserved;
    private String groundSpeed;
    private String atmosphericPressure;
    private String atmosphericTemperature;
    private String relativeHumidity;
    private String numberoffueldatasegments;
    private String fueltemperaturepoints;
    private String interfacelevelstatus;
    private String interfacelevel;
    private String temperatureOne;
    private String temperatureTwo;
    private String temperatureThree;
    private String numberoffuelflow;
    private String fuelflow;
    private String response;

    @Id
    @Column(name = "stockdetailsid")
    public long getStockdetailsid() {
        return stockdetailsid;
    }

    public void setStockdetailsid(long stockdetailsid) {
        this.stockdetailsid = stockdetailsid;
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
    @Column(name = "emg_signal")
    public String getEmgSignal() {
        return emgSignal;
    }

    public void setEmgSignal(String emgSignal) {
        this.emgSignal = emgSignal;
    }

    @Basic
    @Column(name = "fuel_level")
    public BigDecimal getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(BigDecimal fuelLevel) {
        this.fuelLevel = fuelLevel;
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
    @Column(name = "leakage")
    public String getLeakage() {
        return leakage;
    }

    public void setLeakage(String leakage) {
        this.leakage = leakage;
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
    @Column(name = "preorder_level")
    public BigDecimal getPreorderLevel() {
        return preorderLevel;
    }

    public void setPreorderLevel(BigDecimal preorderLevel) {
        this.preorderLevel = preorderLevel;
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
    @Column(name = "storagedetails")
    public String getStorageDetailsid() {
        return storageDetailsid;
    }

    public void setStorageDetailsid(String storageDetailsid) {
        this.storageDetailsid = storageDetailsid;
    }

    @Basic
    @Column(name = "status_time")
    public Timestamp getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(Timestamp statusTime) {
        this.statusTime = statusTime;
    }

    @Basic
    @Column(name = "status_type")
    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "watercontent")
    public BigDecimal getWatercontent() {
        return watercontent;
    }

    public void setWatercontent(BigDecimal watercontent) {
        this.watercontent = watercontent;
    }


    public String getNodeID() {
        return nodeID;
    }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getGprs() {
        return gprs;
    }

    public void setGprs(String gprs) {
        this.gprs = gprs;
    }

    public String getSatellite() {
        return satellite;
    }

    public void setSatellite(String satellite) {
        this.satellite = satellite;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public String getGroundSpeed() {
        return groundSpeed;
    }

    public void setGroundSpeed(String groundSpeed) {
        this.groundSpeed = groundSpeed;
    }

    public String getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(String atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure;
    }

    public String getAtmosphericTemperature() {
        return atmosphericTemperature;
    }

    public void setAtmosphericTemperature(String atmosphericTemperature) {
        this.atmosphericTemperature = atmosphericTemperature;
    }

    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(String relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public String getNumberoffueldatasegments() {
        return numberoffueldatasegments;
    }

    public void setNumberoffueldatasegments(String numberoffueldatasegments) {
        this.numberoffueldatasegments = numberoffueldatasegments;
    }

    public String getFueltemperaturepoints() {
        return fueltemperaturepoints;
    }

    public void setFueltemperaturepoints(String fueltemperaturepoints) {
        this.fueltemperaturepoints = fueltemperaturepoints;
    }

    public String getInterfacelevelstatus() {
        return interfacelevelstatus;
    }

    public void setInterfacelevelstatus(String interfacelevelstatus) {
        this.interfacelevelstatus = interfacelevelstatus;
    }

    public String getInterfacelevel() {
        return interfacelevel;
    }

    public void setInterfacelevel(String interfacelevel) {
        this.interfacelevel = interfacelevel;
    }

    public String getTemperatureOne() {
        return temperatureOne;
    }

    public void setTemperatureOne(String temperatureOne) {
        this.temperatureOne = temperatureOne;
    }

    public String getTemperatureTwo() {
        return temperatureTwo;
    }

    public void setTemperatureTwo(String temperatureTwo) {
        this.temperatureTwo = temperatureTwo;
    }

    public String getTemperatureThree() {
        return temperatureThree;
    }

    public void setTemperatureThree(String temperatureThree) {
        this.temperatureThree = temperatureThree;
    }

    public String getNumberoffuelflow() {
        return numberoffuelflow;
    }

    public void setNumberoffuelflow(String numberoffuelflow) {
        this.numberoffuelflow = numberoffuelflow;
    }

    public String getFuelflow() {
        return fuelflow;
    }

    public void setFuelflow(String fuelflow) {
        this.fuelflow = fuelflow;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }



    @Override
    @Transient
    public Long getId() {

        return  getStockdetailsid();
    }



    @Override
    public String toString() {
        return "GrabberDetails{" +
                "stockdetailsid=" + stockdetailsid +
                ", capacity=" + capacity +
                ", emgSignal='" + emgSignal + '\'' +
                ", fuelLevel=" + fuelLevel +
                ", latitude=" + latitude +
                ", leakage='" + leakage + '\'' +
                ", longitude=" + longitude +
                ", preorderLevel=" + preorderLevel +
                ", pressure=" + pressure +
                ", storageDetailsid='" + storageDetailsid + '\'' +
                ", statusTime=" + statusTime +
                ", statusType='" + statusType + '\'' +
                ", temperature=" + temperature +
                ", type='" + type + '\'' +
                ", watercontent=" + watercontent +
                ", nodeID='" + nodeID + '\'' +
                ", messageID='" + messageID + '\'' +
                ", gsm='" + gsm + '\'' +
                ", gprs='" + gprs + '\'' +
                ", satellite='" + satellite + '\'' +
                ", wifi='" + wifi + '\'' +
                ", bluetooth='" + bluetooth + '\'' +
                ", gps='" + gps + '\'' +
                ", emergency='" + emergency + '\'' +
                ", reserved='" + reserved + '\'' +
                ", groundSpeed='" + groundSpeed + '\'' +
                ", atmosphericPressure='" + atmosphericPressure + '\'' +
                ", atmosphericTemperature='" + atmosphericTemperature + '\'' +
                ", relativeHumidity='" + relativeHumidity + '\'' +
                ", numberoffueldatasegments='" + numberoffueldatasegments + '\'' +
                ", fueltemperaturepoints='" + fueltemperaturepoints + '\'' +
                ", interfacelevelstatus='" + interfacelevelstatus + '\'' +
                ", interfacelevel='" + interfacelevel + '\'' +
                ", temperatureOne='" + temperatureOne + '\'' +
                ", temperatureTwo='" + temperatureTwo + '\'' +
                ", temperatureThree='" + temperatureThree + '\'' +
                ", numberoffuelflow='" + numberoffuelflow + '\'' +
                ", fuelflow='" + fuelflow + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
