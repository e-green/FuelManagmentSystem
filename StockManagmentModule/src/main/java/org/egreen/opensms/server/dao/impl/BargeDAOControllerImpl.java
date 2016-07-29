package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.BargeDAOController;
import org.egreen.opensms.server.entity.Barge;
import org.springframework.stereotype.Repository;

/**
 * Created by Pramoda Fernando on 4/3/2015.
 */

@Repository
public class BargeDAOControllerImpl extends AbstractDAOController<Barge,String> implements BargeDAOController {
    public BargeDAOControllerImpl() {
        super(Barge.class, String.class);
    }
}
