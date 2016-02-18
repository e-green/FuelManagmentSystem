package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.CustomerOrderDAOController;
import org.egreen.opensms.server.entity.Customerorder;
import org.egreen.opensms.server.entity.CustomerorderPK;
import org.egreen.opensms.server.models.FuelChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Pramoda Fernando on 3/20/2015.
 */

@Service
public class CustomerOrderDAOService {

    @Autowired
    private CustomerOrderDAOController customerOrderDAOController;

    /**
     *
     * Save Customer Order
     *
     *
     * @param customerorder
     * @return
     */
    public CustomerorderPK save(Customerorder customerorder) {
        long customerOrderId = new Date().getTime();
        customerorder.setOrderId(customerOrderId);
        customerorder.setStatus(false);
        customerorder.setStoreManagerAproval("NOT");

//
//        final String OLD_FORMAT = "yyyy-MM-dd";
//        final String NEW_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
//        DateFormat formatter = new SimpleDateFormat(OLD_FORMAT);
//        String format = formatter.format(new Date());
//        String oldDateString = format;
//        String newDateString;
//
//
//        Date d = null;
//        try {
//            d = formatter.parse(oldDateString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        ((SimpleDateFormat) formatter).applyPattern(NEW_FORMAT);
//        newDateString = formatter.format(d);
//       // System.out.println(newDateString);
//
//        Timestamp ts = Timestamp.valueOf(newDateString);
        customerorder.setOrderdate(Timestamp.from(Instant.now()));

        getBargeId(5);
        return customerOrderDAOController.create(customerorder);
    }

    /**
     *
     * getCustomerOrderbyCustomerId
     *
     * @param custId
     * @return
     */
    public List<Customerorder> getCustomerOrderbyCustomerId(long custId) {
        return customerOrderDAOController.getAllCustomerOrdersbyCustomerId(custId);

    }


    /**
     *
     * getAllCustomerOrders
     *
     * @return
     */
    public List<Customerorder> getAllCustomerOrders() {
        return customerOrderDAOController.getAll();
    }

    /**
     *
     * Update Customer Order
     *
     * @param customerorder
     * @return
     */
    public int update(Customerorder customerorder) {
        return customerOrderDAOController.updateCustomerOrder(customerorder);
    }

    /**
     *
     * getCustomerOrder
     *
     * @param orderId
     * @return
     */
    public Customerorder getCustomerOrder(Long orderId) {
        return customerOrderDAOController.readCustomerOrder(orderId);
    }


    /**
     *
     * getBargeId
     *
     * @param len
     * @return
     */
    private String getBargeId(int len){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        String returnId = sb.toString();
        Date date = new Date();
        Format formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = formatter.format(date);
        String concat = "BG".concat(returnId);
        return concat;
    }

    /**
     *
     * daily Request Details
     *
     *
     * @return
     */
    public List<Customerorder> dailyRequestDetails() {
        return customerOrderDAOController.dailyRequestDetails();
    }

    /**
     *
     * approveBySalesManager
     *
     * @param customerOrderId
     * @param rate
     * @return
     */
    public CustomerorderPK approveBySalesManager(Long customerOrderId, Double rate) {
        Customerorder customerorder = customerOrderDAOController.readCustomerOrder(customerOrderId);
        customerorder.setStatus(true);
        customerorder.setRate(BigDecimal.valueOf(rate));
        return customerOrderDAOController.update(customerorder);

    }

    /**
     *
     * getApprovalByStoreManager
     *
     *
     * @param customerOrderId
     * @return
     */
    public CustomerorderPK getApprovalByStoreManager(Long customerOrderId) {
        Customerorder customerorder = customerOrderDAOController.readCustomerOrder(customerOrderId);
        customerorder.setStoreManagerAproval("pending");
        return customerOrderDAOController.update(customerorder);
    }


    /**
     *
     * approveByStoreManager
     *
     * @param customerOrderId
     * @param userId
     * @return
     */
    public CustomerorderPK approveByStoreManager(Long customerOrderId,Long userId) {
        System.out.println("cus 2:"+customerOrderId);
        System.out.println("userID 2:"+userId);
        Customerorder customerorder = customerOrderDAOController.readCustomerOrder(customerOrderId);
        customerorder.setStoreManagerAproval("approved");
        customerorder.setApprovedBy(userId);

        final String OLD_FORMAT = "yyyy-MM-dd";
        final String NEW_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
        DateFormat formatter = new SimpleDateFormat(OLD_FORMAT);
        String format = formatter.format(new Date());
        String oldDateString = format;
        String newDateString;

        Date d = null;
        try {
            d = formatter.parse(oldDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ((SimpleDateFormat) formatter).applyPattern(NEW_FORMAT);
        newDateString = formatter.format(d);
        // System.out.println(newDateString);

        Timestamp ts = Timestamp.valueOf(newDateString);
        customerorder.setApprovedDate(ts);


        return customerOrderDAOController.update(customerorder);
    }

    /**
     *
     * pendingCustomerOrder
     *
     *
     * @return
     */
    public List<Customerorder> pendingCustomerOrder() {

        return customerOrderDAOController.pendingCustomerOrder();
    }

    /**
     *
     * incomingRequestNotAprovedCount
     *
     * @return
     */
    public double incomingRequestNotAprovedCount() {
        return customerOrderDAOController.incomingRequestNotAprovedCount();
    }

    /**
     *
     * todayApprovedRequestCount
     *
     * @return
     */
    public double todayApprovedRequestCount() {
        return customerOrderDAOController.todayApprovedRequestCount();
    }


    /**
     *
     * getApprovedRequestOrderCountByUserId
     *
     * @param userId
     * @return
     */
    public List<Customerorder> getApprovedRequestOrderCountByUserId(Long userId) {
        return customerOrderDAOController.getApprovedRequestOrderCountByUserId(userId);
    }

    /**
     *
     * detailChart
     *
     * @return
     */
    public List<FuelChartModel> detailChart() {
        return customerOrderDAOController.detailChart();
    }

    public List<FuelChartModel> dashboardFuelChartByDaily() {


        return customerOrderDAOController.dashboardFuelChartByDaily();
    }
}
