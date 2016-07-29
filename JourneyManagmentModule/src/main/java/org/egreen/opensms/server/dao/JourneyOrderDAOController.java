package org.egreen.opensms.server.dao;

import org.egreen.opensms.server.entity.JourneyOrder;

import java.util.List;

/**
 * Created by Pramoda Fernando on 3/20/2015.
 */
public interface JourneyOrderDAOController extends DAOController<JourneyOrder,Long> {

    List<JourneyOrder> getAllListByDateSort(Long companyjourneyid);
}
