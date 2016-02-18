package org.egreen.opensms.server.entity;

import javax.persistence.*;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */
@Entity
@Table(name = "container_type")
public class ContainerType  implements EntityInterface <Long> {
    private long containerTypeid;
    private String name;

    @Id
    @Column(name = "container_typeid")
    public long getContainerTypeid() {
        return containerTypeid;
    }

    public void setContainerTypeid(long containerTypeid) {
        this.containerTypeid = containerTypeid;
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

        ContainerType that = (ContainerType) o;

        if (containerTypeid != that.containerTypeid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (containerTypeid ^ (containerTypeid >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    @Transient
    public Long getId() {
        return getContainerTypeid();
    }

    @Override
    public String toString() {
        return "ContainerType{" +
                "containerTypeid=" + containerTypeid +
                ", name='" + name + '\'' +
                '}';
    }
}
