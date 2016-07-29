package org.egreen.opensms.server.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Pramoda Fernando on 3/20/2015.
 */
public class CustomerorderPK implements Serializable {
    private long orderId;
    private long customerId;
    private long pumpingId;


    public CustomerorderPK() {
    }

    public CustomerorderPK(long orderId, long customerId, long pumpingId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.pumpingId = pumpingId;
    }

    @Column(name = "orderId")
    @Id
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Column(name = "customer_id")
    @Id
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Column(name = "pumping_id")
    @Id
    public long getPumpingId() {
        return pumpingId;
    }

    public void setPumpingId(long pumpingId) {
        this.pumpingId = pumpingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerorderPK that = (CustomerorderPK) o;

        if (customerId != that.customerId) return false;
        if (orderId != that.orderId) return false;
        if (pumpingId != that.pumpingId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (int) (customerId ^ (customerId >>> 32));
        result = 31 * result + (int) (pumpingId ^ (pumpingId >>> 32));
        return result;
    }
}
