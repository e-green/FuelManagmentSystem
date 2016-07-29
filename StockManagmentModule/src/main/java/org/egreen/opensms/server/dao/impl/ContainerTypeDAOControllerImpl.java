package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.ContainerTypeDAOController;
import org.egreen.opensms.server.dao.TankDAOController;
import org.egreen.opensms.server.entity.ContainerType;
import org.egreen.opensms.server.entity.Tank;
import org.egreen.opensms.server.listner.SecureDispatcher;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by Pramoda Fernando on 4/3/2015.
 */

@Repository
public class ContainerTypeDAOControllerImpl extends AbstractDAOController<ContainerType,Long> implements ContainerTypeDAOController {

    public ContainerTypeDAOControllerImpl() {
        super(ContainerType.class,Long.class);
    }

    public Integer deleteContainertypeById(String containertypeId){

        Session session=getSession();
        String hql = "delete from ContainerType where containerTypeid= :containerTypeid";
        int i = session.createQuery(hql).setString("containerTypeid", containertypeId).executeUpdate();
        return i;
    }

}
