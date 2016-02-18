package org.egreen.opensms.server.service;

import org.egreen.opensms.server.controller.StockPumpingDetailsController;
import org.egreen.opensms.server.dao.StockDetailsDAOController;
import org.egreen.opensms.server.dao.StockPumpingDetailsDAOController;
import org.egreen.opensms.server.entity.StockPumpingDetails;
import org.egreen.opensms.server.entity.Stockdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class StockPumpingDetailsDAOService {

    @Autowired
    private StockPumpingDetailsDAOController stockPumpingDetailsDAOController;
    private List<StockPumpingDetails> allPumpingDetails;


    /**
     *
     * User SignUp
     *
     * @param stockPumpingDetails
     * @return
     */
    public Long save(StockPumpingDetails stockPumpingDetails) {
        long detailId = new Date().getTime();
        stockPumpingDetails.setSpDetailsid(detailId);
        Long aLong = stockPumpingDetailsDAOController.create(stockPumpingDetails);
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


    /**
     *
     * getAllPumpingDetails
     *
     * @return
     */
    public List<StockPumpingDetails> getAllPumpingDetails() {
        return stockPumpingDetailsDAOController.getAll();
    }

    /**
     *
     * getPumpingDetailsById
     *
     * @param stockpumpingdetailsid
     * @return
     */
    public StockPumpingDetails getPumpingDetailsById(Long stockpumpingdetailsid) {

        return stockPumpingDetailsDAOController.read(stockpumpingdetailsid);
    }
}
