package org.egreen.opensms.server.service;

import org.egreen.opensms.server.controller.view.ContainerImpl;
import org.egreen.opensms.server.dao.StoreControllerDAOController;
import org.egreen.opensms.server.entity.StoreContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class StoreControllerDAOService {

    @Autowired
    private StoreControllerDAOController storeControllerDAOController;
    private List<ContainerImpl> allContainerDetails;

    /**
     *
     * Save storeContainer
     *
     *
     * @param storeContainer
     * @param type
     * @return
     */
    public String save(StoreContainer storeContainer,ContainerImpl.Type type) {

        return  storeControllerDAOController.createStoreContainer(storeContainer,type);
    }




    public String saveOb(ContainerImpl container) {
        StoreContainer storeContainer=new StoreContainer();
        storeContainer.setContainerId(container.getContainer_id());
        storeContainer.setLatitude(container.getLatitude());
        storeContainer.setLongitude(container.getLongitude());
        storeContainer.setName(container.getName());
        return save(storeContainer,container.getContainerType());
    }

    public StoreContainer getStoreContainerDetailById(String containerId) {
        return storeControllerDAOController.read(containerId);
    }

    public List<StoreContainer> getAllContainerDetails() {
        return storeControllerDAOController.getAll();
    }
}
