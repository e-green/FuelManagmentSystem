package org.egreen.opensms.server.service;

import org.egreen.opensms.server.controller.ContainerTypeController;
import org.egreen.opensms.server.dao.ContainerTypeDAOController;
import org.egreen.opensms.server.dao.TankDAOController;
import org.egreen.opensms.server.entity.ContainerType;
import org.egreen.opensms.server.entity.Tank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class ContainerTypeDAOService {

    @Autowired
    private ContainerTypeDAOController containerTypeDAOController;


    /**
     *
     * Save Container Type
     *
     * @param containerType
     * @return Long
     */
    public Long save(ContainerType containerType) {
        long containerTypeId = new Date().getTime();
        containerType.setContainerTypeid(containerTypeId);
        return containerTypeDAOController.create(containerType);
    }

    /**
     *
     * Get All Container Type
     *
     * @return List<ContainerType>
     */
    public List<ContainerType> getAllContainerType() {
        return containerTypeDAOController.getAll();
    }
}
