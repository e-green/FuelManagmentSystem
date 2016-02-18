package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.*;
import org.egreen.opensms.server.models.*;
import org.egreen.opensms.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * Created by dewmal on 7/17/14.
 */

@Controller
@RequestMapping("fmms/journey_route/")
public class JourneyRouteController {


    @Autowired
    private JourneyRouteDAOService journeyRouteDAOService;


    /**
     *
     *Save JourneyRoute
     *
     * @param journeyRoute
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage saveJourneyRoute(@RequestBody JourneyRoute journeyRoute) {
        System.out.println(journeyRoute);
        Long res = journeyRouteDAOService.save(journeyRoute);
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
    public JourneyRoute getob() {
        return new JourneyRoute();
    }


}
