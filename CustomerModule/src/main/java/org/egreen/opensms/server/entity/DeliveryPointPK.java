package org.egreen.opensms.server.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */
public class DeliveryPointPK implements Serializable {
    private long detailsId;
    private long customerId;

    public DeliveryPointPK() {
    }

    public DeliveryPointPK(long detailsId, long customerId) {
        this.detailsId=detailsId;
        this.customerId = customerId;
    }

    @Column(name = "details_id")
    @Id
    public long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(long detailsId) {
        this.detailsId = detailsId;
    }

    @Column(name = "customer_id")
    @Id
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryPointPK that = (DeliveryPointPK) o;

        if (customerId != that.customerId) return false;
        if (detailsId != that.detailsId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (detailsId ^ (detailsId >>> 32));
        result = 31 * result + (int) (customerId ^ (customerId >>> 32));
        return result;
    }
}
