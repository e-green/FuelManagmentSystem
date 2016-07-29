package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.StockPumpingDetailsDAOController;
import org.egreen.opensms.server.dao.StockPumpingHasDeliveryPointDAOController;
import org.egreen.opensms.server.entity.StockPumpingDetails;
import org.egreen.opensms.server.entity.StockPumpingHasDeliveryPoint;
import org.springframework.stereotype.Repository;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */

@Repository
public class StockPumpingHasDeliveryPointDAOControllerImpl extends AbstractDAOController<StockPumpingHasDeliveryPoint,Long> implements StockPumpingHasDeliveryPointDAOController {
    public StockPumpingHasDeliveryPointDAOControllerImpl() {
        super(StockPumpingHasDeliveryPoint.class, Long.class);
    }



}
