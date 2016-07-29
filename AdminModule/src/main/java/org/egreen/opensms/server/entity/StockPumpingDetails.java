package org.egreen.opensms.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Pramoda Fernando on 3/19/2015.
 */
@Entity
@Table(name = "stock_pumping_details")
@JsonIgnoreProperties
public class StockPumpingDetails implements EntityInterface <Long>  {
    private long spDetailsid;
    private int diameter;
    private int flangs;


    @Id
    @Column(name = "sp_detailsid")
    public long getSpDetailsid() {
        return spDetailsid;
    }

    public void setSpDetailsid(long spDetailsid) {
        this.spDetailsid = spDetailsid;
    }

    @Basic
    @Column(name = "diameter")
    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Basic
    @Column(name = "flangs")
    public int getFlangs() {
        return flangs;
    }

    public void setFlangs(int flangs) {
        this.flangs = flangs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockPumpingDetails that = (StockPumpingDetails) o;

        if (diameter != that.diameter) return false;
        if (flangs != that.flangs) return false;
        if (spDetailsid != that.spDetailsid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (spDetailsid ^ (spDetailsid >>> 32));
        result = 31 * result + diameter;
        result = 31 * result + flangs;
        return result;
    }

    @Override
    @Transient
    public Long getId() {
        return getSpDetailsid();
    }

    @Override
    public String toString() {
        return "StockPumpingDetails{" +
                "spDetailsid=" + spDetailsid +
                ", diameter=" + diameter +
                ", flangs=" + flangs +
                '}';
    }
}
