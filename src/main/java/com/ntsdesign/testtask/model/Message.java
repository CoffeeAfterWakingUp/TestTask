package com.ntsdesign.testtask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String command;
    private String content;
    private String sessionId;
    private String requestTime;

    public Message(String content, String sessionId, String requestTime) {
        this.content = content;
        this.sessionId = sessionId;
        this.requestTime = requestTime;
    }

    public Message(String command, String sessionId) {
        this.command = command;
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", requestTime='" + requestTime + '\'' +
                '}';
    }
}
