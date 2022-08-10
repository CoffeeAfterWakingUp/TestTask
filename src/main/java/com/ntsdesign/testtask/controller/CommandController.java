package com.ntsdesign.testtask.controller;

import com.ntsdesign.testtask.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class CommandController {

    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    public CommandController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/message")
    public void processMessage() {
        System.out.println("dasdasdasd");
       // messagingTemplate.convertAndSendToUser();

    }

}
