package com.jinnyjinnyjinjin.redischatserver.model;

import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Builder
@Getter
public class ChatRoom implements Serializable {

    @Serial
    private static final long serialVersionUID = 6494678977089006639L;

    private String roomId;
    private String name;
    private long userCount;

    public ChatRoom() {
    }

    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }
}
