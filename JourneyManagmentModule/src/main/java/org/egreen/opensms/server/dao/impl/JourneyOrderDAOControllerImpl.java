package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.JourneyOrderDAOController;
import org.egreen.opensms.server.entity.JourneyOrder;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Pramoda Fernando on 3/20/2015.
 */
@Repository
public class JourneyOrderDAOControllerImpl extends AbstractDAOController<JourneyOrder,Long> implements JourneyOrderDAOController {

    public JourneyOrderDAOControllerImpl() {
        super(JourneyOrder.class, Long.class);
    }


    @Override
    public List<JourneyOrder> getAllListByDateSort(Long companyOrderId) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("companyOrderId", companyOrderId));
        criteria.addOrder(Order.desc("orderDate"));
        return criteria.list();
    }
}
