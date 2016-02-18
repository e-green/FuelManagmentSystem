package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.PumpingTypeDAOController;
import org.egreen.opensms.server.entity.Pumpingtype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class PumpingTypeDAOService {

    @Autowired
    private PumpingTypeDAOController pumpingTypeDAOController;


    /**
     *
     * Save Pumping Type
     *
     * @param pumpingtype
     * @return long detailsId
     */
    public Long save(Pumpingtype pumpingtype) {
        long detailsId = new Date().getTime();
        pumpingtype.setPumpingtypeId(detailsId);
        return pumpingTypeDAOController.create(pumpingtype);

    }

    /**
     *
     * getAllPumpingTypes
     *
     * @return List<Pumpingtype>
     */
    public List<Pumpingtype> getAllPumpingTypes() {
        return pumpingTypeDAOController.getAll();
    }
}
