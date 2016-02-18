package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.TankDAOController;
import org.egreen.opensms.server.entity.Tank;
import org.springframework.stereotype.Repository;

/**
 * Created by Pramoda Fernando on 4/3/2015.
 */

@Repository
public class TankDAOControllerImpl extends AbstractDAOController<Tank,String> implements TankDAOController{

    public TankDAOControllerImpl() {
        super(Tank.class,String.class);
    }
}
