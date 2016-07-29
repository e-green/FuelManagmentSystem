package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.CompatmentHasPumpDAOController;
import org.egreen.opensms.server.dao.TankDAOController;

import org.egreen.opensms.server.entity.CompatmentHasStockPumpingDetails;
import org.egreen.opensms.server.entity.CompatmentHasStockPumpingDetailsPK;
import org.egreen.opensms.server.entity.Tank;
import org.springframework.stereotype.Repository;

/**
 * Created by Pramoda Fernando on 4/3/2015.
 */

@Repository
public class CompatmentHasPumpDAOControllerImpl extends AbstractDAOController<CompatmentHasStockPumpingDetails,CompatmentHasStockPumpingDetailsPK> implements CompatmentHasPumpDAOController {

    public CompatmentHasPumpDAOControllerImpl() {
        super(CompatmentHasStockPumpingDetails.class,CompatmentHasStockPumpingDetailsPK.class);
    }
}
