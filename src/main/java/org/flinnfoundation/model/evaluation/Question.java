package org.flinnfoundation.model.evaluation;

import lombok.Data;

@Data
public class Question {

    private long id;

    private String prompt;

    private String response;
}
