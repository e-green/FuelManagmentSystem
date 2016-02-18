package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.BowserDAOController;
import org.egreen.opensms.server.entity.Bowser;
import org.springframework.stereotype.Repository;

/**
 * Created by Pramoda Fernando on 4/3/2015.
 */

@Repository
public class BowserDAOControllerImpl extends AbstractDAOController<Bowser,String> implements BowserDAOController {
    public BowserDAOControllerImpl() {
        super(Bowser.class, String.class);
    }
}
