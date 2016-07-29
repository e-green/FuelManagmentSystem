package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.Helper.NotificationHelper;
import org.egreen.opensms.server.entity.Customerorder;
import org.egreen.opensms.server.models.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pramoda-nf on 4/30/15.
 */


@Controller
@RequestMapping("fmms/notification")
public class SendMessageController{



    NotificationHelper notificationHelper;


    /**
     *
     * send notification
     *
     * @param notification
     * @return
     */
    @RequestMapping(value = "sendnotification", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage sendnotification(@RequestBody Notification notification) {


        NotificationHelper helper;
        boolean res = false;
        switch (notification.getProtocol()) {
            case EMAIL:
                helper = new NotificationHelper(Protocol.EMAIL);
                res= helper.sendNotification(notification);
                break;

            case SMS:
                helper = new NotificationHelper(Protocol.SMS);
                res=helper.sendNotification(notification);
                break;

            default:
                System.out.println("NOTHING");
                break;
        }




        ResponseMessage responseMessage;
        if(res){
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
    public Notification getob() {
        return new Notification();
    }



}
