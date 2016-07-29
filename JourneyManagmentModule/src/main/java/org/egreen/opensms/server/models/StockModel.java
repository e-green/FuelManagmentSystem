package org.egreen.opensms.server.models;

import org.egreen.opensms.server.entity.Compatment;
import org.egreen.opensms.server.entity.StoreContainer;

/**
 * Created by Pramoda Fernando on 4/22/2015.
 */
public class StockModel {
    private Compatment compatment;
    private StoreContainer storeContainer;

    public Compatment getCompatment() {
        return compatment;
    }

    public void setCompatment(Compatment compatment) {
        this.compatment = compatment;
    }

    public StoreContainer getStoreContainer() {
        return storeContainer;
    }

    public void setStoreContainer(StoreContainer storeContainer) {
        this.storeContainer = storeContainer;
    }
}
