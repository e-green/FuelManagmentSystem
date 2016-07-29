package org.egreen.opensms.server.models;

import org.egreen.opensms.server.controller.Protocol;

/**
 * Created by pramoda-nf on 4/30/15.
 */
public class Notification {

    private Protocol protocol;
    private String message;
    private Long sender;
    private Long reciver;

    public Notification() {
    }

    public Notification(Protocol protocol, String message, Long sender, Long reciver) {
        this.protocol = protocol;
        this.message = message;
        this.sender = sender;
        this.reciver = reciver;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getReciver() {
        return reciver;
    }

    public void setReciver(Long reciver) {
        this.reciver = reciver;
    }
}
