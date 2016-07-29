package org.egreen.opensms.server.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */
@Entity
@Table(name = "compatment")
public class Compatment implements EntityInterface <String> {
    private String compatmentId;
    private String containerId;
    private String status;
    private String stockType;
    private BigDecimal volume;

    @Id
    @Column(name = "compatment_id")
    public String getCompatmentId() {
        return compatmentId;
    }

    public void setCompatmentId(String compatmentId) {
        this.compatmentId = compatmentId;
    }

    @Basic
    @Column(name = "containerId")
    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "stock_type")
    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    @Basic
    @Column(name = "volume")
    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Compatment that = (Compatment) o;

        if (compatmentId != null ? !compatmentId.equals(that.compatmentId) : that.compatmentId != null) return false;
        if (containerId != null ? !containerId.equals(that.containerId) : that.containerId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (stockType != null ? !stockType.equals(that.stockType) : that.stockType != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = compatmentId != null ? compatmentId.hashCode() : 0;
        result = 31 * result + (containerId != null ? containerId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (stockType != null ? stockType.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        return result;
    }

    @Override
    @Transient
    public String getId() {
        return getCompatmentId();
    }

    @Override
    public String toString() {
        return "Compatment{" +
                "compatmentId='" + compatmentId + '\'' +
                ", containerId='" + containerId + '\'' +
                ", status='" + status + '\'' +
                ", stockType='" + stockType + '\'' +
                ", volume=" + volume +
                '}';
    }
}
