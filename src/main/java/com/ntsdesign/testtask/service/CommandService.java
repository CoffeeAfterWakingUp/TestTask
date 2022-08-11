package com.ntsdesign.testtask.service;

import com.ntsdesign.testtask.model.Message;

import java.util.List;

public interface CommandService {

    void addLog(Message message);
    List<Message> getLogs(String sessionId);
}
