package org.egreen.opensms.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Pramoda Fernando on 4/21/2015.
 */

@Entity
@Table(name = "companyjourneyorder")
@JsonIgnoreProperties
public class CompanyJourneyOrder implements EntityInterface<Long> {

    private Long companyOrderId;
    private Timestamp timestamp;
    private String status;


    @Id
    @Column(name = "company_order_id")
    public Long getCompanyOrderId() {
        return companyOrderId;
    }

    public void setCompanyOrderId(Long companyOrderId) {
        this.companyOrderId = companyOrderId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    @Transient
    public Long getId() {
        return getCompanyOrderId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyJourneyOrder that = (CompanyJourneyOrder) o;

        if (companyOrderId != null ? !companyOrderId.equals(that.companyOrderId) : that.companyOrderId != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyOrderId != null ? companyOrderId.hashCode() : 0;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CompanyJourneyOrder{" +
                "companyOrderId=" + companyOrderId +
                ", timestamp=" + timestamp +
                ", status='" + status + '\'' +
                '}';
    }
}
