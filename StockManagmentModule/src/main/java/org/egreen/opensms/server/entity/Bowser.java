package org.egreen.opensms.server.entity;

import javax.persistence.*;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */
@Entity
@Table(name = "bowser")
public class Bowser implements EntityInterface <String> {
    private String bowserId;

    @Id
    @Column(name = "bowser_id")
    public String getBowserId() {
        return bowserId;
    }

    public void setBowserId(String bowserId) {
        this.bowserId = bowserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bowser bowser = (Bowser) o;

        if (bowserId != null ? !bowserId.equals(bowser.bowserId) : bowser.bowserId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return bowserId != null ? bowserId.hashCode() : 0;
    }

    @Override
    @Transient
    public String getId() {
        return getBowserId();
    }

    @Override
    public String toString() {
        return "Bowser{" +
                "bowserId='" + bowserId + '\'' +
                '}';
    }
}
