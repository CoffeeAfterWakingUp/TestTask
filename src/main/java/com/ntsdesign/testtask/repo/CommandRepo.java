package com.ntsdesign.testtask.repo;

import com.ntsdesign.testtask.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandRepo extends JpaRepository<Command, Long> {

    List<Command> findBySessionId(String sessionId);

}
