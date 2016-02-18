package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.DeliveryPointDAOController;
import org.egreen.opensms.server.entity.DeliveryPoint;
import org.egreen.opensms.server.entity.DeliveryPointPK;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */

@Repository
public class DeliveryPointDAOControllerImpl extends AbstractDAOController<DeliveryPoint,DeliveryPointPK> implements DeliveryPointDAOController {
    public DeliveryPointDAOControllerImpl() {
        super(DeliveryPoint.class, DeliveryPointPK.class);
    }


    @Override
    public DeliveryPoint getPumpingDetailById(long pumpingId) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("detailsId", pumpingId));
        DeliveryPoint pumpingDetails = (DeliveryPoint) criteria.uniqueResult();
        return pumpingDetails;
    }

    @Override
    public List<DeliveryPoint> getPumpingDetailsByCustomerId(Long customerId) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("customerId", customerId));
        return criteria.list();
    }
}
