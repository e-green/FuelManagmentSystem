package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.CustomerDAOController;
import org.egreen.opensms.server.entity.Customer;
import org.egreen.opensms.server.models.MailMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class CustomerDAOService {

    @Autowired
    private CustomerDAOController customerDAOController;

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private MailMail mailMail;

    /**
     * Customer SignUp
     *
     * @param customer
     * @return
     */
    public Long register_customer(Customer customer) {
        long Customer_id = new Date().getTime();
        customer.setCustId(Customer_id);
        customer.setStatus(false);

        String encryptWord = authenticationController.getEncryptWord(customer.getPassword());
        customer.setPassword(encryptWord);
//        mailMail.sendMail("voco.egreen@gmail.com", Customer.getEmail(),
//                "(VOCO)Voice Of Community",
//                "http://192.168.1.8:63342/LoginSystem#/verify/"+encryptWord+"/"+Customer_id+"");
        Long aLong = customerDAOController.create(customer);
        return aLong;
    }

    /**
     * Update Gender
     *
     * @param Customer_id
     * @param gender
     * @return
     */
    public Long set_gender(Long Customer_id, String gender) {
        Customer read = customerDAOController.read(Customer_id);
        // read.setGender(gender);
        Long update = customerDAOController.update(read);
        return update;
    }

    /**
     * Update DOB
     *
     * @param Customer_id
     * @param dob
     * @return
     */
    public Long set_dob(Long Customer_id, String dob) {
        Customer read = customerDAOController.read(Customer_id);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp dateofbirth = new Timestamp(date.getTime());
        //  read.setDob(dateofbirth);
        Long update = customerDAOController.update(read);
        return update;
    }

    /**
     * Check Email Validity
     *
     * @param email
     * @return
     */
    public Integer check_email_validity(String email) {
        Integer res = customerDAOController.check_email_validity(email);
        return res;
    }

    /**
     *
     * Get All Details By Customer Id
     *
     * @param CustomerId
     * @return
     */
//    public Customer get_all_details_byCustomerId(Long CustomerId) {
//        return customerDAOController.read(CustomerId);
//    }


    /**
     * Customer Login
     *
     * @param Customername
     * @param password
     * @return
     */
    public Customer login(String Customername, String password) {
        String CustomerPassword = authenticationController.getEncryptWord(password);
        Customer customer = customerDAOController.searchCustomerByEmail(Customername);
        Customer returnCustomer = null;
        if(customer!=null) {
            if (customer.getStatus()) {
                System.out.println("Status");

                if (CustomerPassword.equals(customer.getPassword())) {

                    returnCustomer = customerDAOController.login(Customername, CustomerPassword);
                } else {
                    returnCustomer = null;
                }

            } else {
                System.out.println("StatusNot");
                returnCustomer = null;
            }
        }
        return returnCustomer;
    }

    /**
     * Update Customer
     *
     * @param Customer
     * @return
     */
    public Long edit_Customer(Customer Customer) {
        return customerDAOController.update(Customer);
    }


    /**
     *
     * Reset Password
     *
     * @param email
     * @return
     */
//    public Integer reset_password(String email) {
//        Customer Customer =customerDAOController.reset_password(email);
//        String new_password = randomString(5);
//        mailMail.sendMail("voco.egreen@gmail.com", Customer.getEmail(),
//                "(VOCO)Voice Of Community",
//                "Your New Password :"+new_password+"");
//        String encryptWord = authenticationController.getEncryptWord(new_password);
//        Customer.setPassword(encryptWord);
//        customerDAOController.update(Customer);
//        return 5;
//    }

    /**
     * Random String
     *
     * @param len
     * @return
     */
    private String randomString(int len) {
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    /**
     *
     * Get All Customer Dedails
     *
     * @return
     */
    public List<Customer> get_all_customer_details() {

        return customerDAOController.getAll();

    }

    /**
     *
     * getCustomerDetailsById
     *
     * @param customer_id
     * @return
     */
    public Customer getCustomerDetailsById(Long customer_id) {

        return customerDAOController.read(customer_id);
    }

    /**
     *
     * getAllNotApprovedCustomers
     *
     * @return
     */
    public List<Customer> getAllNotApprovedCustomers() {
        return customerDAOController.getAllNotApprovedCustomers();
    }

    /**
     *
     * updateCustomerStatus
     *
     * @param customer_id
     * @return
     */
    public Long updateCustomerStatus(Long customer_id) {
        Customer customer = customerDAOController.read(customer_id);
        customer.setStatus(true);
        return customerDAOController.update(customer);
    }
}
