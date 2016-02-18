package org.egreen.opensms.server.dao;

import org.egreen.opensms.server.controller.view.ContainerImpl;
import org.egreen.opensms.server.entity.StoreContainer;

/**
 * Created by Pramoda Fernando on 4/3/2015.
 */
public interface StoreControllerDAOController extends DAOController<StoreContainer,String> {
    public String createStoreContainer(StoreContainer entity,ContainerImpl.Type type);
}
