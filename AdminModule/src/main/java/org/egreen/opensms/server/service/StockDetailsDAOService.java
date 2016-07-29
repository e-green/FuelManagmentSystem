package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.StockDetailsDAOController;
import org.egreen.opensms.server.entity.Stockdetails;

import org.egreen.opensms.server.models.MailMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class StockDetailsDAOService {

    @Autowired
    private StockDetailsDAOController stockdetailsdaocontroller;


    /**
     *
     * User SignUp
     *
     * @param stockdetails
     * @return
     */
    public Long save(Stockdetails stockdetails) {
        long detailId = new Date().getTime();
        stockdetails.setStockdetailsid(detailId);
        
        Long aLong = stockdetailsdaocontroller.create(stockdetails);
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



}
