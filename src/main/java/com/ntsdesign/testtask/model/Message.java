package com.ntsdesign.testtask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String command;
    private String content;
    private String sessionId;
    private String requestTime;

    public Message(String content, String sessionId, LocalDateTime requestTime) {
        this.content = content;
        this.sessionId = sessionId;
        this.requestTime = requestTime.toString();
    }

    public Message(String command, String sessionId) {
        this.command = command;
        this.sessionId = sessionId;
    }

    public Message(String command, String content, String sessionId) {
        this.command = command;
        this.content = content;
        this.sessionId = sessionId;
        this.requestTime = LocalDateTime.now().toString();
    }


}
