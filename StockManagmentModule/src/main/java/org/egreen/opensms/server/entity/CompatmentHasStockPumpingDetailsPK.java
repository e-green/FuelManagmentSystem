package org.egreen.opensms.server.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */
public class CompatmentHasStockPumpingDetailsPK implements Serializable {
    private String compatmentCompatmentId;
    private long stockPumpingDetailsSpDetailsid;


    public CompatmentHasStockPumpingDetailsPK() {
    }

    public CompatmentHasStockPumpingDetailsPK(String compatmentCompatmentId, long stockPumpingDetailsSpDetailsid) {
        this.compatmentCompatmentId = compatmentCompatmentId;
        this.stockPumpingDetailsSpDetailsid = stockPumpingDetailsSpDetailsid;
    }

    @Column(name = "compatment_compatment_id")
    @Id
    public String getCompatmentCompatmentId() {
        return compatmentCompatmentId;
    }

    public void setCompatmentCompatmentId(String compatmentCompatmentId) {
        this.compatmentCompatmentId = compatmentCompatmentId;
    }

    @Column(name = "stock_pumping_details_sp_detailsid")
    @Id
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

        CompatmentHasStockPumpingDetailsPK that = (CompatmentHasStockPumpingDetailsPK) o;

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
}
