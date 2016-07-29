package org.egreen.opensms.server.dao;

import org.egreen.opensms.server.entity.Customer;

import java.util.List;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
public interface CustomerDAOController extends DAOController<Customer,Long> {
    Integer check_email_validity(String email);

    Customer login(String username, String password);

    Customer varify_detail(String varification_code, Long user_id);


    Customer reset_password(String email);

    Customer searchCustomerByEmail(String username);

    List<Customer> getAllNotApprovedCustomers();

    Integer deleteCustomerById(String customerId);
}
