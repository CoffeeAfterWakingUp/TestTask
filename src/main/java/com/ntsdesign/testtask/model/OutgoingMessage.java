package com.ntsdesign.testtask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutgoingMessage {

    private Object answer;

    @Override
    public String toString() {
        if (answer instanceof List) {
            return ((List<?>) answer).toString();
        } else if (answer instanceof String) {
            return (String) answer;
        }
        return answer.toString();
    }
}
