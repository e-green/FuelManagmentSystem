package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.CompanyJourneyOrderDAOController;
import org.egreen.opensms.server.entity.CompanyJourneyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Pramoda Fernando on 3/20/2015.
 */

@Service
public class CompanyJourneyOrderDAOService {

    @Autowired
    private CompanyJourneyOrderDAOController companyJourneyOrderDAOController;

    /**
     *
     * Save Company Journey Order
     *
     * @param companyJourneyOrder
     * @return
     */
    public Long save(CompanyJourneyOrder companyJourneyOrder) {
        long companyOrderId = new Date().getTime();
        final String OLD_FORMAT = "yyyy-MM-dd";
        final String NEW_FORMAT = "yyyy-MM-dd HH:mm:ss";
        DateFormat formatter = new SimpleDateFormat(OLD_FORMAT);
        String format = formatter.format(new Date());
        String oldDateString = format;
        String newDateString;


        Date d = null;
        try {
            d = formatter.parse(oldDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ((SimpleDateFormat) formatter).applyPattern(NEW_FORMAT);
        newDateString = formatter.format(d);
        // System.out.println(newDateString);

        Timestamp ts = Timestamp.valueOf(newDateString);


        companyJourneyOrder.setCompanyOrderId(companyOrderId);
        companyJourneyOrder.setTimestamp(ts);

        return companyJourneyOrderDAOController.create(companyJourneyOrder);
    }


}
