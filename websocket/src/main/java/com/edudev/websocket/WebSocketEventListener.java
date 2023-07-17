package com.edudev.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @EventListener
    public void handleWebSocketConnectionListener(SessionConnectedEvent e) {
        logger.info("Received a new web socket connection uhuu");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent e) {
        logger.info("A user was disconnected");
    }

}
