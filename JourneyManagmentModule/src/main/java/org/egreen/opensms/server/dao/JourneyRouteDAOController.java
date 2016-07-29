package org.egreen.opensms.server.dao;

import org.egreen.opensms.server.entity.JourneyOrder;
import org.egreen.opensms.server.entity.JourneyRoute;

import java.util.List;

/**
 * Created by Pramoda Fernando on 3/20/2015.
 */
public interface JourneyRouteDAOController extends DAOController<JourneyRoute,Long> {

    List<JourneyOrder> getAllListByDateSort(Long companyjourneyid);
}
