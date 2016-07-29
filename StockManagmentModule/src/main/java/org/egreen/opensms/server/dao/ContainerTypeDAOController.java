package org.egreen.opensms.server.dao;

import org.egreen.opensms.server.entity.ContainerType;
import org.egreen.opensms.server.entity.Tank;

/**
 * Created by Pramoda Fernando on 4/3/2015.
 */
public interface ContainerTypeDAOController extends DAOController<ContainerType,Long>{
    Integer deleteContainertypeById(String containertypeId);
}
