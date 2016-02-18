package org.egreen.opensms.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.naming.ldap.PagedResultsControl;
import javax.persistence.*;

/**
 * Created by Pramoda Fernando on 4/22/2015.
 */

@Entity
@Table(name = "journeyroute")
@JsonIgnoreProperties
public class JourneyRoute  implements EntityInterface<Long> {

    private Long journeyrouteId;
    private Long customerOrderId;
    private String compatmentId;
    private double amount;
    private  String nextcompatmentId;


    @Id
    @Column(name = "journeyroute_id")
    public Long getJourneyrouteId() {
        return journeyrouteId;
    }

    public void setJourneyrouteId(Long journeyrouteId) {
        this.journeyrouteId = journeyrouteId;
    }

    public Long getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(Long customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getCompatmentId() {
        return compatmentId;
    }

    public void setCompatmentId(String compatmentId) {
        this.compatmentId = compatmentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNextcompatmentId() {
        return nextcompatmentId;
    }

    public void setNextcompatmentId(String nextcompatmentId) {
        this.nextcompatmentId = nextcompatmentId;
    }

    @Override
    @Transient
    public Long getId() {
        return getJourneyrouteId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JourneyRoute that = (JourneyRoute) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (compatmentId != null ? !compatmentId.equals(that.compatmentId) : that.compatmentId != null) return false;
        if (customerOrderId != null ? !customerOrderId.equals(that.customerOrderId) : that.customerOrderId != null)
            return false;
        if (journeyrouteId != null ? !journeyrouteId.equals(that.journeyrouteId) : that.journeyrouteId != null)
            return false;
        if (nextcompatmentId != null ? !nextcompatmentId.equals(that.nextcompatmentId) : that.nextcompatmentId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = journeyrouteId != null ? journeyrouteId.hashCode() : 0;
        result = 31 * result + (customerOrderId != null ? customerOrderId.hashCode() : 0);
        result = 31 * result + (compatmentId != null ? compatmentId.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (nextcompatmentId != null ? nextcompatmentId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JourneyRoute{" +
                "journeyrouteId=" + journeyrouteId +
                ", customerOrderId=" + customerOrderId +
                ", compatmentId='" + compatmentId + '\'' +
                ", amount=" + amount +
                ", nextcompatmentId='" + nextcompatmentId + '\'' +
                '}';
    }
}
