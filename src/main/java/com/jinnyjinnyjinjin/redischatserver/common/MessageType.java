package com.jinnyjinnyjinjin.redischatserver.common;

public enum MessageType {
    ENTER, QUIT, TALK;

    public static boolean isEnter(MessageType type) {
        return MessageType.ENTER == type;
    }
}
