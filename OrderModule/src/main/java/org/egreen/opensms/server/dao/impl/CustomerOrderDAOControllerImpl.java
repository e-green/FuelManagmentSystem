package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.CustomerOrderDAOController;
import org.egreen.opensms.server.entity.Customerorder;
import org.egreen.opensms.server.entity.CustomerorderPK;
import org.egreen.opensms.server.models.FuelChartModel;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.lang.Object;


/**
 * Created by Pramoda Fernando on 3/20/2015.
 */
@Repository
public class CustomerOrderDAOControllerImpl extends AbstractDAOController<Customerorder,CustomerorderPK> implements CustomerOrderDAOController  {

    public CustomerOrderDAOControllerImpl() {
        super(Customerorder.class, CustomerorderPK.class);
    }

    @Override
    public List<Customerorder> getAllCustomerOrdersbyCustomerId(long custId) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("customerId", custId));
        criteria.add(Restrictions.eq("status", false));
        return criteria.list();
    }

    @Override
    public Customerorder readCustomerOrder(Long orderId) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("orderId", orderId));
        return (Customerorder)criteria.uniqueResult();
    }

    @Override
    public int updateCustomerOrder(Customerorder customerorder) {
        Session session=getSession();
        String hql = "UPDATE Customerorder SET pumpingId = :pumpingId,fuelType = :fuelType,volume = :volume WHERE orderId= :orderId";
        Query query = session.createQuery(hql);
        query.setLong("orderId", customerorder.getOrderId());
        query.setLong("pumpingId", customerorder.getPumpingId());
        query.setString("fuelType", customerorder.getFuelType());
        query.setBigDecimal("volume", customerorder.getVolume());
        return query.executeUpdate();

    }

    @Override
    public List<Customerorder> dailyRequestDetails() {
        Session session=getSession();
        String hql = "SELECT co FROM Customerorder co WHERE DATE(orderdate) = DATE(NOW())";
        return session.createQuery(hql).list();
    }

    @Override
    public List<Customerorder> pendingCustomerOrder() {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("storeManagerAproval","pending"));
        return criteria.list();
    }

    @Override
    public double incomingRequestNotAprovedCount() {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.ne("storeManagerAproval","approved"));
        Double totalResult = ((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).doubleValue();
        return totalResult;
    }

    @Override
    public double todayApprovedRequestCount() {
        Session session=getSession();
        String hql = "SELECT COUNT(*) FROM Customerorder co WHERE DATE(approvedDate) = DATE(NOW())";
        Number number = (Number) session.createQuery(hql).uniqueResult();
        System.out.println("COUNT :"+number.doubleValue());
        return number.doubleValue();
//        select COUNT(*) from customerorder WHERE DATE(approvedDate) = DATE(NOW());
    }

    @Override
    public List<Customerorder> getApprovedRequestOrderCountByUserId(Long userId) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.ne("storeManagerAproval","approved"));
        criteria.add(Restrictions.eq("approvedBy", userId));
        return criteria.list();
    }

    @Override
    public List<FuelChartModel> detailChart() {
        Session session=getSession();
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTime());
        instance.add(Calendar.HOUR,-24);
        Date lastDate = instance.getTime();
        String hql = "SELECT co.fuelType,SUM(co.volume) AS volume,co.orderdate FROM Customerorder co WHERE co.orderdate between :lastDate AND DATE(NOW()) GROUP BY fuelType ORDER BY  fuelType";
        Query query = session.createQuery(hql);
        query.setDate("lastDate",lastDate);
       // List list = query.list();

        List<FuelChartModel> listFuelChartModel = new ArrayList<FuelChartModel>();
        Iterator iterator = query.list().iterator();
        FuelChartModel fuelChartModel = null;
        while (iterator.hasNext()) {
            Object[] tuple = (Object[]) iterator.next();
            fuelChartModel = new FuelChartModel(tuple[0]+"",Double.valueOf(tuple[1]+""),tuple[2]+"");
            //  System.out.println("DB MONTHS : "+ incomeSpendingsModel.getMonth());
            listFuelChartModel.add(fuelChartModel);
        }
        return listFuelChartModel;
    }

    @Override
    public List<FuelChartModel> dashboardFuelChartByDaily() {
        Session session=getSession();
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTime());
        instance.add(Calendar.HOUR,-24);
        Date lastDate = instance.getTime();
        String hql = "SELECT co.fuelType,co.volume,co.orderdate FROM Customerorder co WHERE co.orderdate between :lastDate AND DATE(NOW()) GROUP BY orderdate ORDER BY  fuelType";
        Query query = session.createQuery(hql);
        query.setDate("lastDate",lastDate);
        // List list = query.list();

        List<FuelChartModel> listFuelChartModel = new ArrayList<FuelChartModel>();
        Iterator iterator = query.list().iterator();
        FuelChartModel fuelChartModel = null;
        while (iterator.hasNext()) {
            Object[] tuple = (Object[]) iterator.next();
            fuelChartModel = new FuelChartModel(tuple[0]+"",Double.valueOf(tuple[1]+""),tuple[2]+"");
            //  System.out.println("DB MONTHS : "+ incomeSpendingsModel.getMonth());
            listFuelChartModel.add(fuelChartModel);
        }
        return listFuelChartModel;
    }


}
