package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.DataGrabberDAOController;
import org.egreen.opensms.server.entity.GrabberDetails;
import org.egreen.opensms.server.models.MailMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class DataGrabberDAOService {

    @Autowired
    private DataGrabberDAOController dataGrabberDAOController;


    /**
     *
     * save signal
     *
     * @param signal
     * @return
     */
    public Long saveSignal(String signal) {

        long stockdetailsId = new Date().getTime();

        String signal_list[] = signal.split(",");

        String gstorageId = signal_list[0];
        String gfuelLeval = signal_list[1];
        String gtemperature = signal_list[2];
        String gpressure = signal_list[3];
        String glongtitude = signal_list[4];
        String glatitude = signal_list[5];
        String gemgsignal = signal_list[6];
        String gleakage = signal_list[7];

        GrabberDetails grabberDetails = new GrabberDetails();

        grabberDetails.setStockdetailsid(stockdetailsId);
        grabberDetails.setStorageDetailsid(gstorageId);

        double fuelLeval = Double.parseDouble(gfuelLeval);
        grabberDetails.setFuelLevel(BigDecimal.valueOf(fuelLeval));

        double temperature = Double.parseDouble(gtemperature);
        grabberDetails.setTemperature(BigDecimal.valueOf(temperature));


        double pressure = Double.parseDouble(gpressure);
        grabberDetails.setPressure(BigDecimal.valueOf(pressure));

        double longtitude = Double.parseDouble(glongtitude);
        grabberDetails.setLongitude(BigDecimal.valueOf(longtitude));

        double latitude = Double.parseDouble(glatitude);
        grabberDetails.setLatitude(BigDecimal.valueOf(latitude));

        grabberDetails.setEmgSignal(gemgsignal);

        grabberDetails.setLeakage(gleakage);

        grabberDetails.setStatusTime(new Timestamp(new Date().getTime()));

        Long aLong = dataGrabberDAOController.create(grabberDetails);
        return stockdetailsId;
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


    public GrabberDetails getAllGrabberDetailsByStorageId(String storageId) {
        return dataGrabberDAOController.getAllGrabberDetailsByStorageId(storageId);
    }

    public List<GrabberDetails> getAll( Integer limit, Integer offset) {
        return dataGrabberDAOController.getAll(offset,limit,"nodeID");
    }


    public List<GrabberDetails> getAllByNodeIdOrMessageId(String nodeId, Integer limit, Integer offset, Integer type, String firstDate, String secondDate) throws ParseException {
        return dataGrabberDAOController.getAllByNodeIdOrMessageId( nodeId,  limit,  offset,  type,firstDate,secondDate) ;
    }

    public Long save(GrabberDetails grabberDetails) {

        return dataGrabberDAOController.create(grabberDetails);
    }
}
