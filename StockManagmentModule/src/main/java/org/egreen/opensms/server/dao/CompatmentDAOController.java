package org.egreen.opensms.server.dao;

import org.egreen.opensms.server.entity.Barge;
import org.egreen.opensms.server.entity.Compatment;

import java.util.List;

/**
 * Created by Pramoda Fernando on 4/3/2015.
 */
public interface CompatmentDAOController extends DAOController<Compatment,String>{
    List<Compatment> getBargeStockDetailByFuelType(String fuelType);

    List<Compatment> getShipStockDetailByFuelType(String fuelType);

    List<Compatment> getTankStockDetailByFuelType(String fuelType);

    List<Compatment> getBowserStockDetailByFuelType(String fuelType);
}
