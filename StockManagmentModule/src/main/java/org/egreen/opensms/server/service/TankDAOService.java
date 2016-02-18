package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.TankDAOController;
import org.egreen.opensms.server.entity.Bowser;
import org.egreen.opensms.server.entity.Tank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class TankDAOService {

    @Autowired
    private TankDAOController tankDAOController;

    /**
     *
     * Save
     *
     * @param tank
     * @return
     */
    public String save(Tank tank) {

//        String tankId = getTankId(5);
//        tank.setTankId(tankId);
        return tankDAOController.create(tank);
    }


    private String getTankId(int len){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        String returnId = sb.toString();
        String ret = returnId.concat("TNK"+new Date().getTime());
        return ret;
    }

    public List<Tank> getAllTanks() {
        return tankDAOController.getAll();

    }



}
