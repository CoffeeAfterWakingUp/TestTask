package com.ntsdesign.testtask.client;

import com.ntsdesign.testtask.model.OutgoingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

@Slf4j
public class MyStompSessionHandler extends StompSessionHandlerAdapter {


    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        log.info("New session established : {}", session.getSessionId());
        session.subscribe("/topic/messages", this);
        log.info("Subscribed to /topic/messages");
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        log.error("Got an exception", exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return OutgoingMessage.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        OutgoingMessage outgoingMessage = (OutgoingMessage) payload;
        log.info("Received: {}", outgoingMessage.getAnswer());

    }
}
