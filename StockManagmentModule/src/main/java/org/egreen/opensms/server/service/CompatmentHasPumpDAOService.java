package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.BargeDAOController;
import org.egreen.opensms.server.dao.CompatmentHasPumpDAOController;
import org.egreen.opensms.server.entity.Barge;

import org.egreen.opensms.server.entity.CompatmentHasStockPumpingDetails;
import org.egreen.opensms.server.entity.CompatmentHasStockPumpingDetailsPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class CompatmentHasPumpDAOService {

    @Autowired
    private CompatmentHasPumpDAOController compatmentHasPumpDAOController;


    /**
     *
     * Save Compatment Has Pump
     *
     *
     * @param compatmentHasStockPumpingDetails
     * @return
     */
    public CompatmentHasStockPumpingDetailsPK save(CompatmentHasStockPumpingDetails compatmentHasStockPumpingDetails) {
        //long comhaspumpId = new Date().getTime();
        compatmentHasStockPumpingDetails.setCompatmentCompatmentId(getcsp(10));
        return compatmentHasPumpDAOController.create(compatmentHasStockPumpingDetails);
    }


    /**
     *
     * getcsp
     *
     * @param len
     * @return
     */
    private String getcsp(int len){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        String returnId = sb.toString();
        String ret = returnId.concat("BW"+new Date().getTime());
        return ret;
    }


}
