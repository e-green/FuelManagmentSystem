package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.ShipDAOController;
import org.egreen.opensms.server.entity.Ship;
import org.springframework.stereotype.Repository;

/**
 * Created by Pramoda Fernando on 4/3/2015.
 */

@Repository
public class ShipDAOControllerImpl extends AbstractDAOController<Ship,String> implements ShipDAOController {
    public ShipDAOControllerImpl() {
        super(Ship.class,String.class);
    }
}
