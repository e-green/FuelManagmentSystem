package org.egreen.opensms.server.controller.view;

import org.egreen.opensms.server.entity.Barge;
import org.egreen.opensms.server.entity.Container;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */
public class ContainerImpl implements Container {


    private Type containerType;
    private String container_id;
    private String longitude;
    private String latitude;
    private String name;


    public Type getContainerType() {
        return containerType;
    }

    public void setContainerType(Type containerType) {
        this.containerType = containerType;
    }

    public String getContainer_id() {
        return container_id;
    }

    public void setContainer_id(String container_id) {
        this.container_id = container_id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public enum Type{
        ship("SH"),
        barge("BG"),
        tank("TK"),
        bowser("BW")        ;

        private String type;

        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
