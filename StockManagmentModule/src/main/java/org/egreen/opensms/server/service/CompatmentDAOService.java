package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.BowserDAOController;
import org.egreen.opensms.server.dao.CompatmentDAOController;
import org.egreen.opensms.server.entity.Bowser;
import org.egreen.opensms.server.entity.Compatment;
import org.egreen.opensms.server.entity.CompatmentHasStockPumpingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class CompatmentDAOService {

    @Autowired
    private CompatmentDAOController compatmentDAOController;

    /**
     *
     * Save Compatment
     *
     * @param compatment
     * @return
     */
    public String save(Compatment compatment)

    {
        String compatmentId = getCompatmentId(5);
        compatment.setCompatmentId(compatmentId);

        CompatmentHasStockPumpingDetails stockPumpingDetails =  new CompatmentHasStockPumpingDetails();
        stockPumpingDetails.setCompatmentCompatmentId(compatmentId);
       // stockPumpingDetails.setStockPumpingDetailsSpDetailsid();
        return compatmentDAOController.create(compatment);
    }

    /**
     *
     * getCompatmentId
     *
     * @param len
     * @return
     */
    private String getCompatmentId(int len){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        String returnId = sb.toString();
        String ret = returnId.concat("COM"+new Date().getTime());
        return ret;
    }

    /**
     *
     * getAllCompatmentByBargeId
     *
     * @param bargeId
     * @return
     */
    public List<Compatment> getAllCompatmentByBargeId(String bargeId) {

        return compatmentDAOController.getAllByPropertyByStringValue(bargeId,"containerId");
    }


    /**
     *
     * getBargeStockDetailByFuelType
     *
     * @param fuelType
     * @return
     */
    public List<Compatment> getBargeStockDetailByFuelType(String fuelType) {
        return compatmentDAOController.getBargeStockDetailByFuelType(fuelType);
    }

    /**
     *
     * getShipStockDetailByFuelType
     *
     *
     * @param fuelType
     * @return
     */
    public List<Compatment> getShipStockDetailByFuelType(String fuelType) {
        return compatmentDAOController.getShipStockDetailByFuelType(fuelType);
    }

    /**
     *
     * getTankStockDetailByFuelType
     *
     * @param fuelType
     * @return
     */
    public List<Compatment> getTankStockDetailByFuelType(String fuelType) {
        return compatmentDAOController.getTankStockDetailByFuelType(fuelType);
    }

    /**
     *
     * getBowserStockDetailByFuelType
     *
     * @param fuelType
     * @return
     */
    public List<Compatment> getBowserStockDetailByFuelType(String fuelType) {
        return compatmentDAOController.getBowserStockDetailByFuelType(fuelType);
    }
}
