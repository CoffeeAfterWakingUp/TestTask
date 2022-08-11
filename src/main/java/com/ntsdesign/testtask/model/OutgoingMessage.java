package com.ntsdesign.testtask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutgoingMessage {

    private Object answer;

    @Override
    public String toString() {
        if(answer instanceof List) {
            return Arrays.asList((Object[])answer).toString();
        } else if(answer instanceof String) {
            return (String)answer;
        }
        return answer.toString();
    }
}
