package org.egreen.opensms.server.dao.impl;

import org.egreen.opensms.server.dao.CompanyJourneyOrderDAOController;
import org.egreen.opensms.server.entity.CompanyJourneyOrder;
import org.springframework.stereotype.Repository;

/**
 * Created by Pramoda Fernando on 4/21/2015.
 */
@Repository
public class CompanyJourneyOrderDAOControllerImpl extends AbstractDAOController<CompanyJourneyOrder,Long> implements CompanyJourneyOrderDAOController {

    public CompanyJourneyOrderDAOControllerImpl() {
        super(CompanyJourneyOrder.class, Long.class);
    }


}