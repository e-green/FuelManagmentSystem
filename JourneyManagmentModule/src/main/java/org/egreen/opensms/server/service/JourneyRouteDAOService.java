package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.JourneyOrderDAOController;
import org.egreen.opensms.server.dao.JourneyRouteDAOController;
import org.egreen.opensms.server.entity.JourneyOrder;
import org.egreen.opensms.server.entity.JourneyRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Pramoda Fernando on 3/20/2015.
 */

@Service
public class JourneyRouteDAOService {

    @Autowired
    private JourneyRouteDAOController journeyRouteDAOController;

    /**
     *
     * Save Journey Route
     *
     * @param journeyRoute
     * @return
     */
    public Long save(JourneyRoute journeyRoute) {
        long journeyrouteOrderId = new Date().getTime();
        journeyRoute.setJourneyrouteId(journeyrouteOrderId);
        return journeyRouteDAOController.create(journeyRoute);
    }


    /**
     *
     * getAllJourneyOrders
     *
     * @param companyjourneyid
     * @return
     */
    public List<JourneyOrder> getAllJourneyOrders(Long companyjourneyid) {
        return journeyRouteDAOController.getAllListByDateSort(companyjourneyid);
    }
}
