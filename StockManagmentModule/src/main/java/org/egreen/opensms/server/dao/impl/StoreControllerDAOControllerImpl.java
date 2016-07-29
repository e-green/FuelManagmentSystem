package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.controller.view.ContainerImpl;
import org.egreen.opensms.server.dao.StoreControllerDAOController;
import org.egreen.opensms.server.entity.StoreContainer;
import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * Created by Pramoda Fernando on 4/3/2015.
 */

@Repository
public class StoreControllerDAOControllerImpl extends AbstractDAOController<StoreContainer,String> implements StoreControllerDAOController {
    public StoreControllerDAOControllerImpl() {
        super(StoreContainer.class,String.class);
    }

    public String createStoreContainer(StoreContainer entity, ContainerImpl.Type type) {

        String containerID = genrateContainerID(5, type.getType());
        entity.setContainerId(containerID);

        super.create(entity);

        return containerID;
    }

    private String genrateContainerID(int len, String type) {
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        String returnId = sb.toString();

        String concat = type.concat(returnId);
        return concat;
    }
}
