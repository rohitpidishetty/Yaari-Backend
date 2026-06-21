package com.jud.yaari.Yaari.Backend.Code.DTO;

public class MessageDTO {
    public MessageDTO(String message_id, String sender_username, String receiver_username, String text, String timestamp) {
        this.message_id = message_id;
        this.sender_username = sender_username;
        this.receiver_username = receiver_username;
        this.text = text;
        this.timestamp = timestamp;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getSender_username() {
        return sender_username;
    }

    public void setSender_username(String sender_username) {
        this.sender_username = sender_username;
    }

    public String getReceiver_username() {
        return receiver_username;
    }

    public void setReceiver_username(String receiver_username) {
        this.receiver_username = receiver_username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String message_id, sender_username, receiver_username, text;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String timestamp;

}
