package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.BargeDAOController;
import org.egreen.opensms.server.dao.CompatmentDAOController;
import org.egreen.opensms.server.entity.Barge;
import org.egreen.opensms.server.entity.Compatment;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pramoda Fernando on 4/3/2015.
 */

@Repository
public class CompatmentDAOControllerImpl extends AbstractDAOController<Compatment,String> implements CompatmentDAOController {
    public CompatmentDAOControllerImpl() {
        super(Compatment.class, String.class);
    }

    @Override
    public List<Compatment> getBargeStockDetailByFuelType(String fuelType) {
        Session session=getSession();
        String hql = "SELECT compatment FROM Compatment compatment where compatment.containerId IN (SELECT barge.bargeId FROM Barge barge)AND  compatment.stockType IN  (:fuelType) order by compatment.stockType ";
        return session.createQuery(hql).setString("fuelType",fuelType).list();
    }

    @Override
    public List<Compatment> getShipStockDetailByFuelType(String fuelType) {
        Session session=getSession();
        String hql = "SELECT compatment FROM Compatment compatment where compatment.containerId IN (SELECT ship.shipId FROM Ship ship)AND  compatment.stockType IN  (:fuelType) order by compatment.stockType ";
        return session.createQuery(hql).setString("fuelType",fuelType).list();
    }

    @Override
    public List<Compatment> getTankStockDetailByFuelType(String fuelType) {
        Session session=getSession();
        String hql = "SELECT compatment FROM Compatment compatment where compatment.containerId IN (SELECT tank.tankId FROM Tank tank)AND  compatment.stockType IN  (:fuelType) order by compatment.stockType ";
        return session.createQuery(hql).setString("fuelType",fuelType).list();
    }

    @Override
    public List<Compatment> getBowserStockDetailByFuelType(String fuelType) {
        Session session=getSession();
        String hql = "SELECT compatment FROM Compatment compatment where compatment.containerId IN (SELECT bowser.bowserId FROM Bowser bowser)AND  compatment.stockType IN  (:fuelType) order by compatment.stockType ";
        return session.createQuery(hql).setString("fuelType",fuelType).list();
    }
}
