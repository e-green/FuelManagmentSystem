package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.StockDetailsDAOController;
import org.egreen.opensms.server.dao.StockPumpingDetailsDAOController;
import org.egreen.opensms.server.entity.StockPumpingDetails;
import org.egreen.opensms.server.entity.Stockdetails;
import org.springframework.stereotype.Repository;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */

@Repository
public class StockPumpingDetailsDAOControllerImpl extends AbstractDAOController<StockPumpingDetails,Long> implements StockPumpingDetailsDAOController {
    public StockPumpingDetailsDAOControllerImpl() {
        super(StockPumpingDetails.class, Long.class);
    }



}
