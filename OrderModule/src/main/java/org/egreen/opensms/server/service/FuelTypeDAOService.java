package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.FuelTypeDAOController;
import org.egreen.opensms.server.entity.Fueltype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */

@Service
public class FuelTypeDAOService {

    @Autowired
    private FuelTypeDAOController fuelTypeDAOController;

    /**
     *
     * Save Fuel Type
     *
     *
     * @param fueltype
     * @return
     */
    public Long save(Fueltype fueltype) {

        fueltype.setFuelTypeId(new Date().getTime());
        return fuelTypeDAOController.create(fueltype);
    }

    /**
     *
     * getAllFueltype
     *
     * @return
     */
    public List<Fueltype> getAllFueltype() {
       return fuelTypeDAOController.getAll();
    }

    /**
     *
     * getAllFueltypeByID
     *
     * @param fueltypeId
     * @return
     */
    public Fueltype getAllFueltypeByID(Long fueltypeId) {
        return fuelTypeDAOController.read(fueltypeId);
    }

    public Integer deleteFueltypeById(Long fueltypeId) { return fuelTypeDAOController.deleteFueltypeById(fueltypeId);
    }
}
