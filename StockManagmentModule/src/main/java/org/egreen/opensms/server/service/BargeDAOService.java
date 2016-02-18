package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.BargeDAOController;
import org.egreen.opensms.server.entity.Barge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class BargeDAOService {

    @Autowired
    private BargeDAOController bargeDAOController;


    /**
     *
     * Save Barge
     *
     * @param barge
     * @return
     */
    public String save(Barge barge) {

//        String bargeId = getBargeId(5);
//        barge.setBargeId(bargeId);
        return bargeDAOController.create(barge);

    }

    /**
     *
     * getBargeId
     *
     * @param len
     * @return
     */
    private String getBargeId(int len){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        String returnId = sb.toString();

        String concat = "BG".concat(returnId);
        return concat;
    }

    /**
     *
     * getAllBarges
     *
     * @return
     */
    public List<Barge> getAllBarges() {
        return bargeDAOController.getAll();
    }
}
