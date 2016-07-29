package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.GrabberDetails;
import org.egreen.opensms.server.service.DataGrabberDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


/**
 * Created by dewmal on 7/17/14.
 */
@Controller
@RequestMapping("fmms/grabber/")
public class DataGrabberController {

    @Autowired
    private DataGrabberDAOService dataGrabberDAOService;



    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage saveSignal(@RequestParam("signal") String signal) {
        Long res = dataGrabberDAOService.saveSignal(signal);
        ResponseMessage responseMessage;
        if(res != null){
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        }else{
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    @RequestMapping(value = "saveGrabberDetails", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage save(@RequestBody GrabberDetails  grabberDetails) {
        Long res = dataGrabberDAOService.save(grabberDetails);
        ResponseMessage responseMessage;
        if(res != null){
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        }else{
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    @RequestMapping(value = "getAllGrabberDetailsByStorageId", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage getAllGrabberDetailsByStorageId(@RequestParam("storageId")String storageId){
        GrabberDetails res = dataGrabberDAOService.getAllGrabberDetailsByStorageId(storageId);
        ResponseMessage responseMessage;
        if(res != null){
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        }else{
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    /**
     *
     * getAll
     *
     * @param limit
     * @param offset
     * @return
     */
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<GrabberDetails> getAll(@RequestParam("limit")Integer limit,
                                       @RequestParam("offset")Integer offset){

      return   dataGrabberDAOService.getAll(limit,offset);

    }

    /**
     *
     * type 0 = nodeId;
     * type 1 = messageId;
     *
     *
     * getAllByNodeIdOrMessageId
     *
     *
     * @param nodeId
     * @param limit
     * @param offset
     * @param type
     * @param firstDate
     * @param secondDate
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "getAllByNodeIdOrMessageId", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage getAllByNodeIdOrMessageId(@RequestParam("nodeId")String nodeId,
                                                     @RequestParam("limit")Integer limit,
                                  @RequestParam("offset")Integer offset,
                                  @RequestParam("type")Integer type,
                                  @RequestParam("firstDate")String firstDate,
                                  @RequestParam("secondDate")String secondDate) throws ParseException {
        List<GrabberDetails> res = dataGrabberDAOService.getAllByNodeIdOrMessageId(nodeId, limit, offset, type, firstDate, secondDate);
        ResponseMessage responseMessage;
        if(res != null){
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        }else{
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }



    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public GrabberDetails getob() {
        return new GrabberDetails();
    }


}
