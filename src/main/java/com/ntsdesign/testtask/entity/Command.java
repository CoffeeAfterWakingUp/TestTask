package com.ntsdesign.testtask.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    private String sessionId;

    private String requestTime;

    public Command(String content, String sessionId, String requestTime) {
        this.content = content;
        this.sessionId = sessionId;
        this.requestTime = requestTime;
    }
}
