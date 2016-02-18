package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.BowserDAOController;
import org.egreen.opensms.server.entity.Bowser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class BowserDAOService {

    @Autowired
    private BowserDAOController bowserDAOController;


    /**
     *
     * Save Bowser
     *
     * @param bowser
     * @return
     */
    public String save(Bowser bowser) {

//        String bowserId = getBowserId(5);
//        bowser.setBowserId(bowserId);
        return bowserDAOController.create(bowser);
    }


    /**
     *
     * getBowserId
     *
     * @param len
     * @return
     */
    private String getBowserId(int len){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        String returnId = sb.toString();
        String ret = returnId.concat("BW"+new Date().getTime());
        return ret;
    }

    /**
     *
     * getAllBowsers
     *
     * @return
     */
    public List<Bowser> getAllBowsers() {
        return bowserDAOController.getAll();

    }
}
