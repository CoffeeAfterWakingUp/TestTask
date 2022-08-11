package com.ntsdesign.testtask.service;

import com.ntsdesign.testtask.entity.Command;
import com.ntsdesign.testtask.model.Message;
import com.ntsdesign.testtask.repo.CommandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandServiceImpl implements CommandService {

    private final CommandRepo commandRepo;

    @Autowired
    public CommandServiceImpl(CommandRepo commandRepo) {
        this.commandRepo = commandRepo;
    }

    @Override
    public void addLog(Message message) {
        Command command = new Command(message.getContent(), message.getSessionId(), message.getRequestTime());
        commandRepo.save(command);
    }

    @Override
    public List<Message> getLogs(String sessionId) {
        List<Command> commands = commandRepo.findBySessionId(sessionId);
        List<Message> messages = new ArrayList<>();
        commands.forEach(c -> {
            Message message = new Message(c.getContent(), c.getSessionId(), c.getRequestTime());
            messages.add(message);
        });
        return messages;
    }
}
