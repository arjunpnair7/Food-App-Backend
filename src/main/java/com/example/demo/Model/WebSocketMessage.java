package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.aspectj.bridge.Message;

import java.util.List;

@Getter
public class WebSocketMessage {
    public enum MessageType {
        START_VOTING,
        DONE,
        CODE,
        USER_LIST,
        DATA,
        DONE_VOTING,
        NOT_DONE
        // Add more message types as needed
    }
    private MessageType type;
    private Object data;

    public WebSocketMessage() {
    }

    public WebSocketMessage(MessageType type) {
        this.type = type;
    }

    public WebSocketMessage(MessageType type, Object data) {
        this.type = type;
        this.data = data;
    }
}
