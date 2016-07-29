package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.controller.view.ContainerImpl;
import org.egreen.opensms.server.entity.*;
import org.egreen.opensms.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Pramoda Fernando on 4/7/2015.
 */


@Controller
@RequestMapping("fmms/store_controller")
public class StoreController {


    @Autowired
    private BargeDAOService bargeDAOService;


    @Autowired
    private BowserDAOService bowserDAOService;

    @Autowired
    private ShipDAOService shipDAOService;

    @Autowired
    private TankDAOService tankDAOService;

    @Autowired
    private StoreControllerDAOService storeControllerDAOService;


    /**
     *
     * Save Store Controller
     *
     * @param container
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage save(@RequestBody ContainerImpl container) {
        String res = null;

        Container container1=container;

        String containerId = storeControllerDAOService.saveOb(container);

        System.out.println("Container Id : "+containerId);

        switch (container.getContainerType()) {
            case ship: {
                Ship ship = new Ship();
                ship.setShipId(containerId);
                res = shipDAOService.save(ship);
                break;
            }
            case barge: {
                Barge barge =new Barge();
                barge.setBargeId(containerId);
                res = bargeDAOService.save(barge);
                break;
            }
            case tank: {
                Tank tank =new Tank();
                tank.setTankId(containerId);
                res = tankDAOService.save(tank);
                break;
            }
            case bowser: {
                Bowser bowser =new Bowser();
                bowser.setBowserId(containerId);
                res = bowserDAOService.save(bowser);
                break;
            }
        }

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
    public ContainerImpl getob() {
        return new ContainerImpl();
    }

    /**
     *
     * getAllContainerDetails
     *
     * @return
     */
    @RequestMapping(value = "getAllContainerDetails", method = RequestMethod.GET)
    @ResponseBody
    public List<StoreContainer> getAllContainerDetails() {

        return storeControllerDAOService.getAllContainerDetails();
    }
}
