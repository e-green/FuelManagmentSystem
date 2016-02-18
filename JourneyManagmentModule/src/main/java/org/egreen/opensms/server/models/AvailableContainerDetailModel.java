package org.egreen.opensms.server.models;

import org.egreen.opensms.server.entity.Compatment;
import org.egreen.opensms.server.entity.StoreContainer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Pramoda Fernando on 4/8/2015.
 */
public class AvailableContainerDetailModel {

    private String containerId;
    private List<Compatment>compatmentList;
    private StoreContainer storeContainer;
    private Map<String, Double> totalVolume;


    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public List<Compatment> getCompatmentList() {
        return compatmentList;
    }

    public void setCompatmentList(List<Compatment> compatmentList) {
        this.compatmentList = compatmentList;
    }

    public StoreContainer getStoreContainer() {
        return storeContainer;
    }

    public void setStoreContainer(StoreContainer storeContainer) {
        this.storeContainer = storeContainer;
    }

    public Map<String, Double> getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Map<String, Double> totalVolume) {
        this.totalVolume = totalVolume;
    }
}
