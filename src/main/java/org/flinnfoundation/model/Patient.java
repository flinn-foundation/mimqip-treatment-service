package org.flinnfoundation.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Patient {

    private LocalDate lastEvaluationDate;

    private List<String> messageTags = new ArrayList<>();

    public void addMessageTag(String messageTag) {
        messageTags.add(messageTag);
    }

}
