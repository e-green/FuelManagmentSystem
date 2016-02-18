package org.egreen.opensms.server.Helper;

import org.egreen.opensms.server.controller.Protocol;
import org.egreen.opensms.server.models.MailMail;
import org.egreen.opensms.server.models.Notification;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pramoda-nf on 4/30/15.
 */


public class NotificationHelper {

    @Autowired
    MailMail mailMail;


    Protocol protocol;

    public NotificationHelper(Protocol protocol) {
        this.protocol = protocol;
    }

//    public boolean sendEmail(Notification notification){
//        mailMail.sendMail("egreendeveloperteam@gmail.com", notification.getSender(),
//                "(Egreen Team)Things go Better",
//                "Your Order Placed Successfully");
//        return true;
//    }

    public boolean sendNotification(Notification notification) {
        switch (protocol) {
            case EMAIL:

                mailMail.sendMail("egreendeveloperteam@gmail.com", "pramodafernando@gmail.com",
                        "(Egreen Team)Things go Better",
                        "Your Order Placed Successfully");
                return true;


            case SMS:
                System.out.println("SMS");
                return true;

            default:
                System.out.println("NOTHING");
                return true;
        }
    }


}
