package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.JourneyOrderDAOController;
import org.egreen.opensms.server.dao.JourneyRouteDAOController;
import org.egreen.opensms.server.entity.JourneyOrder;
import org.egreen.opensms.server.entity.JourneyRoute;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pramoda Fernando on 3/20/2015.
 */
@Repository
public class JourneyRouteDAOControllerImpl extends AbstractDAOController<JourneyRoute,Long> implements JourneyRouteDAOController {

    public JourneyRouteDAOControllerImpl() {
        super(JourneyRoute.class, Long.class);
    }


    @Override
    public List<JourneyOrder> getAllListByDateSort(Long companyOrderId) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("companyOrderId", companyOrderId));
        criteria.addOrder(Order.desc("orderDate"));
        return criteria.list();
    }
}
