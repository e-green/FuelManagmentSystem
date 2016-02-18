package org.egreen.opensms.server.dao;

import org.egreen.opensms.server.entity.Customerorder;
import org.egreen.opensms.server.entity.CustomerorderPK;
import org.egreen.opensms.server.models.FuelChartModel;

import java.util.List;

/**
 * Created by Pramoda Fernando on 3/20/2015.
 */
public interface CustomerOrderDAOController extends DAOController<Customerorder,CustomerorderPK> {
    List<Customerorder> getAllCustomerOrdersbyCustomerId(long custId);

    Customerorder readCustomerOrder(Long orderId);


    int updateCustomerOrder(Customerorder customerorder);

    List<Customerorder> dailyRequestDetails();

    List<Customerorder> pendingCustomerOrder();

    double incomingRequestNotAprovedCount();

    double todayApprovedRequestCount();


    List<Customerorder> getApprovedRequestOrderCountByUserId(Long userId);

    List<FuelChartModel> detailChart() ;


    List<FuelChartModel> dashboardFuelChartByDaily();

}
