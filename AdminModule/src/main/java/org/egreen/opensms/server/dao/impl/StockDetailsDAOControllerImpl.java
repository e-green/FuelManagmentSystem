package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.StockDetailsDAOController;
import org.egreen.opensms.server.entity.Stockdetails;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */

@Repository
public class StockDetailsDAOControllerImpl extends AbstractDAOController<Stockdetails,Long> implements StockDetailsDAOController {
    public StockDetailsDAOControllerImpl() {
        super(Stockdetails.class, Long.class);
    }

//    @Override
//    public Integer check_email_validity(String email){
//        Criteria criteria = getSession().createCriteria(entityType);
//        criteria.add(Restrictions.eq("email", email));
//
//
//
//            Object o = criteria.uniqueResult();
//            if (o != null) {
//                return 1;
//            }else{
//                return 0;
//            }
//    }

//    @Override
//    public User login(String username, String password) {
//        Criteria criteria = getSession().createCriteria(entityType);
//        criteria.add(Restrictions.eq("user_name", username));
//        criteria.add(Restrictions.eq("password", password));
//        User o = (User)criteria.uniqueResult();
//        if (o != null) {
//            return o;
//        }else{
//            return null;
//        }
//    }
//
//    @Override
//    public User varify_detail(String varification_code, Long user_id) {
//        Criteria criteria = getSession().createCriteria(entityType);
//        criteria.add(Restrictions.eq("user_id", user_id));
//        criteria.add(Restrictions.eq("varification_id", varification_code));
//        return (User)criteria.uniqueResult();
//    }
//
//    @Override
//    public User searchUserByEmail(String username) {
//        Criteria criteria = getSession().createCriteria(entityType);
//        criteria.add(Restrictions.eq("user_name", username));
//        return (User)criteria.uniqueResult();
//    }
//
//    @Override
//    public User reset_password(String email) {
//        Criteria criteria = getSession().createCriteria(entityType);
//        criteria.add(Restrictions.eq("email", email));
//        return (User)criteria.uniqueResult();
//    }




}
