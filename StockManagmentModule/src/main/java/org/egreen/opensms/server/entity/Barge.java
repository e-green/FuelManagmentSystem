package org.egreen.opensms.server.entity;

import javax.persistence.*;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */
@Entity
@Table(name = "barge")
public class Barge implements EntityInterface <String> {
    private String bargeId;

    @Id
    @Column(name = "barge_id")
    public String getBargeId() {
        return bargeId;
    }

    public void setBargeId(String bargeId) {
        this.bargeId = bargeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Barge barge = (Barge) o;

        if (bargeId != null ? !bargeId.equals(barge.bargeId) : barge.bargeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return bargeId != null ? bargeId.hashCode() : 0;
    }

    @Override
    @Transient
    public String getId() {
        return getBargeId();
    }

    @Override
    public String toString() {
        return "Barge{" +
                "bargeId='" + bargeId + '\'' +
                '}';
    }
}
