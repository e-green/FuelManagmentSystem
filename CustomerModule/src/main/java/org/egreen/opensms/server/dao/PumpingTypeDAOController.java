package org.egreen.opensms.server.dao;

import org.egreen.opensms.server.entity.Pumpingtype;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
public interface PumpingTypeDAOController extends DAOController<Pumpingtype,Long> {


    Integer deletePumoingtypeById(String pumpingtypeId);
}
