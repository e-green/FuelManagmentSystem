package org.egreen.opensms.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

/**
 * Created by Pramoda Fernando on 4/6/2015.
 */
@Entity
@Table(name = "pumpingtype")
@JsonIgnoreProperties
public class Pumpingtype implements EntityInterface <Long> {
    private long pumpingtypeId;
    private String name;

    @Id
    @Column(name = "pumpingtype_id")
    public long getPumpingtypeId() {
        return pumpingtypeId;
    }

    public void setPumpingtypeId(long pumpingtypeId) {
        this.pumpingtypeId = pumpingtypeId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pumpingtype that = (Pumpingtype) o;

        if (pumpingtypeId != that.pumpingtypeId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (pumpingtypeId ^ (pumpingtypeId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    @Transient
    public Long getId() {
        return getPumpingtypeId();
    }

    @Override
    public String toString() {
        return "Pumpingtype{" +
                "pumpingtypeId=" + pumpingtypeId +
                ", name='" + name + '\'' +
                '}';
    }
}
