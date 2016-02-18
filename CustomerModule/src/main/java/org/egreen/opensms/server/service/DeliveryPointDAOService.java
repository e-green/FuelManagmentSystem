package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.DeliveryPointDAOController;
import org.egreen.opensms.server.entity.DeliveryPoint;
import org.egreen.opensms.server.entity.DeliveryPointPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class DeliveryPointDAOService {

    @Autowired
    private DeliveryPointDAOController deliveryPointDAOController;


    /**
     *
     * Save Delivery Point
     *
     * @param deliveryPoint
     * @return
     */
    public DeliveryPointPK save(DeliveryPoint deliveryPoint) {
        long detailsId = new Date().getTime();
        deliveryPoint.setDetailsId(detailsId);
        return deliveryPointDAOController.create(deliveryPoint);

    }

    /**
     *
     * getPumpingDetailById
     *
     * @param pumpingId
     * @return
     */
    public DeliveryPoint getPumpingDetailById(long pumpingId) {

        return deliveryPointDAOController.getPumpingDetailById(pumpingId);
    }

    /**
     *
     * getPumpingDetailsByCustomerId
     *
     * @param customerId
     * @return
     */
    public List<DeliveryPoint> getPumpingDetailsByCustomerId(Long customerId) {

        return deliveryPointDAOController.getPumpingDetailsByCustomerId(customerId);
    }

    /**
     *
     * getAllDeliveryPoint
     *
     * @return
     */
    public List<DeliveryPoint> getAllDeliveryPoint() {
        return deliveryPointDAOController.getAll();

    }

    /**
     *
     * getOrderDeliveryPoint
     *
     * @param pumpingId
     * @return
     */
    public DeliveryPoint getOrderDeliveryPoint(long pumpingId) {
        return deliveryPointDAOController.getPumpingDetailById(pumpingId);
    }
}
