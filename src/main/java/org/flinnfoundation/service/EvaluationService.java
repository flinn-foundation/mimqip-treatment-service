package org.flinnfoundation.service;


import org.flinnfoundation.model.evaluation.Evaluation;
import org.flinnfoundation.model.evaluation.EvaluationType;

import java.util.List;

public interface EvaluationService {

    List<Evaluation> getEvaluations(long patientId);

    List<Evaluation> getEvaluations(long patientId, EvaluationType evaluationType);

}
