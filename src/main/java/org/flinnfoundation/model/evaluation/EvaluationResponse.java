package org.flinnfoundation.model.evaluation;

import lombok.Data;

@Data
public class EvaluationResponse {

    private long id;

    private String prompt;

    private String answer;
}
