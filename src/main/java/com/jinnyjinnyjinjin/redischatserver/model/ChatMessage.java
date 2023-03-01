package com.jinnyjinnyjinjin.redischatserver.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChatMessage {

    private String messageType;
    private String roomId;
    private String sender;
    private String message;
    private long userCount;

}
