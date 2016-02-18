package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.DataGrabberDAOController;
import org.egreen.opensms.server.entity.GrabberDetails;
import org.egreen.opensms.server.entity.GrabberDetails;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by Pramoda Fernando on 1/14/2015.
 */

@Repository
public class DataGrabberDAOControllerImpl extends AbstractDAOController<GrabberDetails,Long> implements DataGrabberDAOController {
    public DataGrabberDAOControllerImpl() {
        super(GrabberDetails.class, Long.class);
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
    public GrabberDetails login(String username, String password) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("email", username));
        criteria.add(Restrictions.eq("password", password));
        GrabberDetails o = (GrabberDetails)criteria.uniqueResult();
        if (o != null) {
            return o;
        }else{
            return null;
        }
    }

    @Override
    public GrabberDetails varify_detail(String varification_code, Long user_id) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("user_id", user_id));
        criteria.add(Restrictions.eq("varification_id", varification_code));
        return (GrabberDetails)criteria.uniqueResult();
    }

    @Override
    public GrabberDetails searchGrabberDetailsByEmail(String username) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("email", username));
        return (GrabberDetails)criteria.uniqueResult();
    }

    @Override
    public GrabberDetails getAllGrabberDetailsByStorageId(String storageId) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("storageDetailsid", storageId));
        criteria.addOrder(Order.desc("statusTime"));
       criteria.setMaxResults(1);
        GrabberDetails grabberDetail = (GrabberDetails) criteria.uniqueResult();
        return grabberDetail;
    }

    @Override
    public List<GrabberDetails> getAllByNodeIdOrMessageId(String Id,
                                                          Integer limit,
                                                          Integer offset,
                                                          Integer type,
                                                          String firstDate,
                                                          String secondDate) throws ParseException {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date first = sm.parse(firstDate);
        Date second = sm.parse(secondDate);

        Calendar dateOneCal = Calendar.getInstance();
        dateOneCal.setTime(first);
        dateOneCal.set(Calendar.HOUR, 0);
        dateOneCal.set(Calendar.MINUTE, 0);

        Calendar dateTwoCal = Calendar.getInstance();
        dateTwoCal.setTime(second);
        dateTwoCal.set(Calendar.HOUR, 23);
        dateTwoCal.set(Calendar.MINUTE, 59);
        Query query = null;


        if (type==0) {
            query = getSession().createQuery("SELECT g FROM GrabberDetails g WHERE g.nodeID= :nodeId AND g.statusTime BETWEEN :dateONE AND :dateTwo");
            query.setString("nodeId", Id);
        }else  if (type==1){
            query = getSession().createQuery("SELECT g FROM GrabberDetails g WHERE g.messageID= :messageID AND g.statusTime BETWEEN :dateONE AND :dateTwo");
            query.setString("messageID", Id);
        }

        query.setDate("dateONE", dateOneCal.getTime());
        query.setDate("dateTwo", dateTwoCal.getTime());

        if (limit != null && offset != null) {
            query.setFirstResult(offset);
            query.setMaxResults(limit);
        }
        return query.list();
    }

    @Override
    public GrabberDetails reset_password(String email) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("email", email));
        return (GrabberDetails)criteria.uniqueResult();
    }




}
