package org.egreen.opensms.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */
@Entity
@Table(name = "stock_pumping_details_has_delivery_point")
@JsonIgnoreProperties
public class StockPumpingHasDeliveryPoint implements EntityInterface <Long>{

    private Long stockpumpingHasdeliverypointid;
    private Long stockpumpingdetailsid;
    private Long deliverypointid;



    @Id
    @Column(name = "sthasdeliveryid")
    public Long getStockpumpingHasdeliverypointid() {
        return stockpumpingHasdeliverypointid;
    }

    public void setStockpumpingHasdeliverypointid(Long stockpumpingHasdeliverypointid) {
        this.stockpumpingHasdeliverypointid = stockpumpingHasdeliverypointid;
    }

    @Id
    @Column(name = "stockpumpingdetailsid")
    public Long getStockpumpingdetailsid() {
        return stockpumpingdetailsid;
    }

    public void setStockpumpingdetailsid(Long stockpumpingdetailsid) {
        this.stockpumpingdetailsid = stockpumpingdetailsid;
    }

    @Id
    @Column(name = "deliverypointid")
    public Long getDeliverypointid() {
        return deliverypointid;
    }

    public void setDeliverypointid(Long deliverypointid) {
        this.deliverypointid = deliverypointid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockPumpingHasDeliveryPoint that = (StockPumpingHasDeliveryPoint) o;

        if (deliverypointid != null ? !deliverypointid.equals(that.deliverypointid) : that.deliverypointid != null)
            return false;
        if (stockpumpingHasdeliverypointid != null ? !stockpumpingHasdeliverypointid.equals(that.stockpumpingHasdeliverypointid) : that.stockpumpingHasdeliverypointid != null)
            return false;
        if (stockpumpingdetailsid != null ? !stockpumpingdetailsid.equals(that.stockpumpingdetailsid) : that.stockpumpingdetailsid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockpumpingHasdeliverypointid != null ? stockpumpingHasdeliverypointid.hashCode() : 0;
        result = 31 * result + (stockpumpingdetailsid != null ? stockpumpingdetailsid.hashCode() : 0);
        result = 31 * result + (deliverypointid != null ? deliverypointid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StockPumpingHasDeliveryPoint{" +
                "stockpumpingHasdeliverypointid=" + stockpumpingHasdeliverypointid +
                ", stockpumpingdetailsid=" + stockpumpingdetailsid +
                ", deliverypointid=" + deliverypointid +
                '}';
    }


    @Override
    @Transient
    public Long getId() {
        return getStockpumpingHasdeliverypointid();
    }
}
