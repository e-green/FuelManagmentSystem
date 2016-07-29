package org.egreen.opensms.server.dao;

import org.egreen.opensms.server.entity.DeliveryPoint;
import org.egreen.opensms.server.entity.DeliveryPointPK;


import java.util.List;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
public interface DeliveryPointDAOController extends DAOController<DeliveryPoint,DeliveryPointPK> {

    DeliveryPoint getPumpingDetailById(long pumpingId);

    List<DeliveryPoint> getPumpingDetailsByCustomerId(Long customerId);
}
