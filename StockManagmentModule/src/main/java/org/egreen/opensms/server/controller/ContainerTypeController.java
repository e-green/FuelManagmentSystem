package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.ContainerType;
import org.egreen.opensms.server.service.ContainerTypeDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by dewmal on 7/17/14.
 */
@Controller
@RequestMapping("fmms/container_type")
public class ContainerTypeController {

    @Autowired
    private ContainerTypeDAOService containerTypeDAOService;


    /**
     *
     * Save Container Type
     *
     * @param containerType
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage save(@RequestBody ContainerType containerType) {
        Long res = containerTypeDAOService.save(containerType);
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

    /**
     *
     * getAllContainerType
     *
     * @return
     */
    @RequestMapping(value = "getAllContainerType", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage getAllContainerType() {
        List<ContainerType> res = containerTypeDAOService.getAllContainerType();
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
    public ContainerType getob() {
        return new ContainerType();
    }


}
