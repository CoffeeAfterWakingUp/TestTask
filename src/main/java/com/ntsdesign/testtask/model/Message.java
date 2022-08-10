package com.ntsdesign.testtask.model;

public class Message {
    private String command;
    private String content;

    public Message(String command, String content) {
        this.command = command;
        this.content = content;
    }

    public Message(){}

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
