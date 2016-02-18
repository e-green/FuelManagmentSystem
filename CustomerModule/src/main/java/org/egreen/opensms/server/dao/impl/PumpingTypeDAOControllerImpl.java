package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.PumpingTypeDAOController;
import org.egreen.opensms.server.entity.Pumpingtype;
import org.springframework.stereotype.Repository;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */

@Repository
public class PumpingTypeDAOControllerImpl extends AbstractDAOController<Pumpingtype,Long> implements PumpingTypeDAOController {
    public PumpingTypeDAOControllerImpl() {
        super(Pumpingtype.class, Long.class);
    }


}
