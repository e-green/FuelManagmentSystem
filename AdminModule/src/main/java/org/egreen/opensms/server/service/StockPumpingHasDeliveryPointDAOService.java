package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.StockPumpingDetailsDAOController;
import org.egreen.opensms.server.dao.StockPumpingHasDeliveryPointDAOController;
import org.egreen.opensms.server.entity.StockPumpingDetails;
import org.egreen.opensms.server.entity.StockPumpingHasDeliveryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class StockPumpingHasDeliveryPointDAOService {

    @Autowired
    private StockPumpingHasDeliveryPointDAOController stockPumpingHasDeliveryPointDAOController;



    /**
     *
     * User SignUp
     *
     * @param stockPumpingHasDeliveryPoint
     * @return
     */
    public Long save(StockPumpingHasDeliveryPoint stockPumpingHasDeliveryPoint) {
        long detailId = new Date().getTime();
        stockPumpingHasDeliveryPoint.setStockpumpingHasdeliverypointid(detailId);
        Long aLong = stockPumpingHasDeliveryPointDAOController.create(stockPumpingHasDeliveryPoint);
        return aLong;
    }









    /**
     *
     * Random String
     *
     * @param len
     * @return
     */
    private String randomString(int len){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }


    public List<StockPumpingHasDeliveryPoint> getAllPumpingHasDeliveryPoint() {
        return stockPumpingHasDeliveryPointDAOController.getAll();
    }

    public List<StockPumpingHasDeliveryPoint> getStockHasDeliveryPointById(long detailsId) {
        return stockPumpingHasDeliveryPointDAOController.getAllListById(detailsId,"deliverypointid");
    }
}
