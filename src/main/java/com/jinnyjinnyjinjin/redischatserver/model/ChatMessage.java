package com.jinnyjinnyjinjin.redischatserver.model;

import com.jinnyjinnyjinjin.redischatserver.common.MessageType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChatMessage {

    private MessageType type;
    private String roomId;
    private String sender;
    private String content;
    private long userCount;

}
