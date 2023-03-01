package com.jinnyjinnyjinjin.redischatserver.model;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class ChatRoom {

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
