package org.flinnfoundation.model.evaluation;

import lombok.Data;
import org.flinnfoundation.model.Patient;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class Evaluation {

    private long id;

    private Patient patient;

    private List<EvaluationResponse> evaluationResponses;

    private EvaluationType evaluationType;

    private OffsetDateTime created;

}
