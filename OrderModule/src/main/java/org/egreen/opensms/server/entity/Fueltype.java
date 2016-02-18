package org.egreen.opensms.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */
@Entity
@Table(name = "fueltype")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fueltype implements EntityInterface <Long> {
    private long fuelTypeId;
    private String name;
    private String colourcode;

    @Id
    @Column(name = "fuel_type_Id")
    public long getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(long fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "colourcode")
    public String getColourcode() {
        return colourcode;
    }

    public void setColourcode(String colourcode) {
        this.colourcode = colourcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fueltype fueltype = (Fueltype) o;

        if (fuelTypeId != fueltype.fuelTypeId) return false;
        if (name != null ? !name.equals(fueltype.name) : fueltype.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (fuelTypeId ^ (fuelTypeId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    @Transient
    public Long getId() {
        return getFuelTypeId();
    }

    @Override
    public String toString() {
        return "Fueltype{" +
                "fuelTypeId=" + fuelTypeId +
                ", name='" + name + '\'' +
                '}';
    }
}
