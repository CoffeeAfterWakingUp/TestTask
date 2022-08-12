package com.ntsdesign.testtask.controller;

import com.ntsdesign.testtask.model.Message;
import com.ntsdesign.testtask.model.OutgoingMessage;
import com.ntsdesign.testtask.service.CommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class CommandController {

    private CommandService commandService;

    @Autowired
    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutgoingMessage processMessage(@Payload Message message) {
        log.info("Processing message {}", message);
        OutgoingMessage outgoingMessage = new OutgoingMessage();
        if (message.getContent() != null) {
            commandService.addLog(message);
            outgoingMessage.setAnswer("Content added!");
        } else {
            outgoingMessage.setAnswer(commandService.getLogs(message.getSessionId()));
        }
        return outgoingMessage;
    }


}
