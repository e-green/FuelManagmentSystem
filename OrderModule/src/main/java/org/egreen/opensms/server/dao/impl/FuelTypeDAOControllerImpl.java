package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.CustomerOrderDAOController;
import org.egreen.opensms.server.dao.FuelTypeDAOController;
import org.egreen.opensms.server.entity.Customerorder;
import org.egreen.opensms.server.entity.CustomerorderPK;
import org.egreen.opensms.server.entity.Fueltype;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pramoda Fernando on 3/20/2015.
 */
@Repository
public class FuelTypeDAOControllerImpl extends AbstractDAOController<Fueltype,Long> implements FuelTypeDAOController {

    public FuelTypeDAOControllerImpl() {
        super(Fueltype.class, Long.class);
    }




}
