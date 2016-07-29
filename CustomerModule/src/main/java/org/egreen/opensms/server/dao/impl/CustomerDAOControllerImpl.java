package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.CustomerDAOController;
import org.egreen.opensms.server.entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */

@Repository
public class CustomerDAOControllerImpl extends AbstractDAOController<Customer,Long> implements CustomerDAOController {
    public CustomerDAOControllerImpl() {
        super(Customer.class, Long.class);
    }

    @Override
    public Integer check_email_validity(String email){
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("email", email));



            Object o = criteria.uniqueResult();
            if (o != null) {
                return 1;
            }else{
                return 0;
            }
    }

    @Override
    public Customer login(String username, String password) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("email", username));
        criteria.add(Restrictions.eq("password", password));
        Customer o = (Customer)criteria.uniqueResult();
        if (o != null) {
            return o;
        }else{
            return null;
        }
    }

    @Override
    public Customer varify_detail(String varification_code, Long user_id) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("user_id", user_id));
        criteria.add(Restrictions.eq("varification_id", varification_code));
        return (Customer)criteria.uniqueResult();
    }

    @Override
    public Customer searchCustomerByEmail(String username) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("email", username));
        return (Customer)criteria.uniqueResult();
    }

    @Override
    public List<Customer> getAllNotApprovedCustomers() {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("status", false));
        return criteria.list();
    }

    @Override
    public Customer reset_password(String email) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("email", email));
        return (Customer)criteria.uniqueResult();
    }

    @Override
    public Integer deleteCustomerById(String customerId){
        Session session=getSession();
        String hql = "delete from Customer where customerid= :customerid";
        int i = session.createQuery(hql).setString("customerid", customerId).executeUpdate();
        return i;
    }


}
