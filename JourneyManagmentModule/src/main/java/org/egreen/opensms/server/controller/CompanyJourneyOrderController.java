package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.CompanyJourneyOrder;
import org.egreen.opensms.server.service.CompanyJourneyOrderDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by dewmal on 7/17/14.
 */
@Controller
@RequestMapping("fmms/company_order/")
public class CompanyJourneyOrderController {


    @Autowired
    private CompanyJourneyOrderDAOService companyJourneyOrderDAOService;


    /**
     *
     * Save CompanyJourneyOrder
     *
     * @param companyJourneyOrder
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage saveJourneyOrder(@RequestBody CompanyJourneyOrder companyJourneyOrder) {

        Long res = companyJourneyOrderDAOService.save(companyJourneyOrder);

        ResponseMessage responseMessage;
        if (res != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }





    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public CompanyJourneyOrder getob() {
        return new CompanyJourneyOrder();
    }


}
