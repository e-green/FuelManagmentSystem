package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.JourneyOrderDAOController;
import org.egreen.opensms.server.entity.JourneyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Pramoda Fernando on 3/20/2015.
 */

@Service
public class JourneyDAOService {

    @Autowired
    private JourneyOrderDAOController journeyOrderDAOController;

    /**
     *
     * Save Journey Order
     *
     * @param journeyOrder
     * @return
     */
    public Long save(JourneyOrder journeyOrder) {
        long journeyOrderId = new Date().getTime();
        journeyOrder.setJourneyid(journeyOrderId);
        return journeyOrderDAOController.create(journeyOrder);
    }


    /**
     *
     * getAllJourneyOrders
     *
     * @param companyjourneyid
     * @return
     */
    public List<JourneyOrder> getAllJourneyOrders(Long companyjourneyid) {

        return journeyOrderDAOController.getAllListByDateSort(companyjourneyid);


    }
}
