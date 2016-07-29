package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.ShipDAOController;
import org.egreen.opensms.server.entity.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class ShipDAOService {

    @Autowired
    private ShipDAOController shipDAOController;


    /**
     *
     * Save Ship
     *
     * @param ship
     * @return
     */
    public String save(Ship ship) {
//        String shipId = getShipId(5);
//        ship.setShipId(shipId);
        return shipDAOController.create(ship);
    }


    /**
     *
     * getShipId
     *
     * @param len
     * @return
     */
    private String getShipId(int len){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        String returnId = sb.toString();
        String ret = returnId.concat("SH"+new Date().getTime());
        return ret;
    }

    /**
     *
     * getAllShips
     *
     * @return
     */
    public List<Ship> getAllShips() {
        return shipDAOController.getAll();
    }
}
