package com.ntsdesign.testtask.client;

import com.ntsdesign.testtask.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Client {

    private static final String URL = "ws://localhost:8080/websocket-server";


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        WebSocketClient client = new StandardWebSocketClient();

        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        StompSessionHandler sessionHandler = new MyStompSessionHandler();
        StompSession session = stompClient.connect(URL, sessionHandler).get();


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Command: ");
            String command = scanner.next();
            if(command.equals("logs")) {
                session.send("/app/chat", new Message(command, session.getSessionId()));
                log.info("Message sent to websocket server");
            } else if(command.equals("addLog")) {
                System.out.println("Content: ");
                String content = scanner.next();
                session.send("/app/chat", new Message(command, content, session.getSessionId()));
                log.info("Message sent to websocket server");
            } else {
                System.out.println("Please try another command!");
            }
        }

    }

}
