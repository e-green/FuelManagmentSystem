package org.egreen.opensms.server.models;

import org.egreen.opensms.server.entity.Customer;
import org.egreen.opensms.server.entity.Customerorder;
import org.egreen.opensms.server.entity.DeliveryPoint;

import java.util.List;

/**
 * Created by Pramoda Fernando on 3/20/2015.
 */
public class CustomerRequestModel {
    private Customer customer;
    private List<Customerorder> customerorderlist;
    private List<DeliveryPoint> pumpingdetailslist;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customerorder> getCustomerorderlist() {
        return customerorderlist;
    }

    public void setCustomerorderlist(List<Customerorder> customerorderlist) {
        this.customerorderlist = customerorderlist;
    }

    public List<DeliveryPoint> getPumpingdetailslist() {
        return pumpingdetailslist;
    }

    public void setPumpingdetailslist(List<DeliveryPoint> pumpingdetailslist) {
        this.pumpingdetailslist = pumpingdetailslist;
    }
}
