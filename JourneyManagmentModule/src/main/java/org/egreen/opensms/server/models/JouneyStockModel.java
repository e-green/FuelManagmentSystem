package org.egreen.opensms.server.models;

import org.egreen.opensms.server.entity.Compatment;

import java.util.List;

/**
 * Created by Pramoda Fernando on 4/22/2015.
 */
public class JouneyStockModel {
    List<StockModel> bargelist;
    List<StockModel> shiplist;
    List<StockModel> bowserlist;
    List<StockModel> tanklist;


    public List<StockModel> getBargelist() {
        return bargelist;
    }

    public void setBargelist(List<StockModel> bargelist) {
        this.bargelist = bargelist;
    }

    public List<StockModel> getShiplist() {
        return shiplist;
    }

    public void setShiplist(List<StockModel> shiplist) {
        this.shiplist = shiplist;
    }

    public List<StockModel> getBowserlist() {
        return bowserlist;
    }

    public void setBowserlist(List<StockModel> bowserlist) {
        this.bowserlist = bowserlist;
    }

    public List<StockModel> getTanklist() {
        return tanklist;
    }

    public void setTanklist(List<StockModel> tanklist) {
        this.tanklist = tanklist;
    }
}
