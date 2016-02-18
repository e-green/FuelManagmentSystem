package org.egreen.opensms.server.entity;

import javax.persistence.*;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */
@Entity
@Table(name = "ship")
public class Ship implements EntityInterface <String> {
    private String shipId;

    @Id
    @Column(name = "ship_id")
    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        if (shipId != null ? !shipId.equals(ship.shipId) : ship.shipId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return shipId != null ? shipId.hashCode() : 0;
    }

    @Override
    @Transient
    public String getId() {
        return getShipId();
    }

    @Override
    public String toString() {
        return "Ship{" +
                "shipId='" + shipId + '\'' +
                '}';
    }
}
