package org.egreen.opensms.server.entity;

import javax.persistence.*;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */
@Entity
@Table(name = "tank")
public class Tank implements EntityInterface <String>{
    private String tankId;

    @Id
    @Column(name = "tank_id")
    public String getTankId() {
        return tankId;
    }

    public void setTankId(String tankId) {
        this.tankId = tankId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tank tank = (Tank) o;

        if (tankId != null ? !tankId.equals(tank.tankId) : tank.tankId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return tankId != null ? tankId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "tankId='" + tankId + '\'' +
                '}';
    }

    @Override
    @Transient
    public String getId() {
        return getTankId();
    }
}
