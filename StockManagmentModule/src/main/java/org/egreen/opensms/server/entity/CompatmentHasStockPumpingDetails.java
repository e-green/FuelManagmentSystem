package org.egreen.opensms.server.entity;

import javax.persistence.*;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */
@Entity
@Table(name = "compatment_has_stock_pumping_details")
@IdClass(CompatmentHasStockPumpingDetailsPK.class)
public class CompatmentHasStockPumpingDetails implements EntityInterface<CompatmentHasStockPumpingDetailsPK> {

    private String compatmentCompatmentId;
    private long stockPumpingDetailsSpDetailsid;


    @Id
    @Column(name = "compatment_compatment_id")
    public String getCompatmentCompatmentId() {
        return compatmentCompatmentId;
    }

    public void setCompatmentCompatmentId(String compatmentCompatmentId) {
        this.compatmentCompatmentId = compatmentCompatmentId;
    }

    @Id
    @Column(name = "stock_pumping_details_sp_detailsid")
    public long getStockPumpingDetailsSpDetailsid() {
        return stockPumpingDetailsSpDetailsid;
    }

    public void setStockPumpingDetailsSpDetailsid(long stockPumpingDetailsSpDetailsid) {
        this.stockPumpingDetailsSpDetailsid = stockPumpingDetailsSpDetailsid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompatmentHasStockPumpingDetails that = (CompatmentHasStockPumpingDetails) o;

        if (stockPumpingDetailsSpDetailsid != that.stockPumpingDetailsSpDetailsid) return false;
        if (compatmentCompatmentId != null ? !compatmentCompatmentId.equals(that.compatmentCompatmentId) : that.compatmentCompatmentId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = compatmentCompatmentId != null ? compatmentCompatmentId.hashCode() : 0;
        result = 31 * result + (int) (stockPumpingDetailsSpDetailsid ^ (stockPumpingDetailsSpDetailsid >>> 32));
        return result;
    }



    @Override
    @Transient
    public CompatmentHasStockPumpingDetailsPK getId() {
        return new CompatmentHasStockPumpingDetailsPK(getCompatmentCompatmentId(),getStockPumpingDetailsSpDetailsid());
    }

    @Override
    public String toString() {
        return "CompatmentHasStockPumpingDetails{" +
                "compatmentCompatmentId='" + compatmentCompatmentId + '\'' +
                ", stockPumpingDetailsSpDetailsid=" + stockPumpingDetailsSpDetailsid +
                '}';
    }
}
