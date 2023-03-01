package com.jinnyjinnyjinjin.redischatserver.controller;

import com.jinnyjinnyjinjin.redischatserver.RedisPublisher;
import com.jinnyjinnyjinjin.redischatserver.common.MessageType;
import com.jinnyjinnyjinjin.redischatserver.controller.response.ChatResponse;
import com.jinnyjinnyjinjin.redischatserver.model.ChatMessage;
import com.jinnyjinnyjinjin.redischatserver.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final RedisPublisher redisPublisher;
    private final ChatRoomRepository chatRoomRepository;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        ChatResponse response = null;
        if (MessageType.isEnter(message.getType())) {
            chatRoomRepository.enterChatRoom(message.getRoomId());
            response = ChatResponse.builder()
                    .content(message.getSender() + "님이 입장하셨습니다.")
                    .build();
        }
        redisPublisher.publish(chatRoomRepository.getTopic(message.getRoomId()), response);
    }
}
