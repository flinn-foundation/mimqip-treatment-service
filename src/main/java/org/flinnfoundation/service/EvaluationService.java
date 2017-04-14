package org.flinnfoundation.service;


import org.flinnfoundation.model.Patient;
import org.flinnfoundation.model.evaluation.Evaluation;
import org.flinnfoundation.model.evaluation.EvaluationType;

import java.util.List;

public interface EvaluationService {

    List<Evaluation> getEvaluations(Patient patient);

    List<Evaluation> getEvaluations(Patient patient, EvaluationType evaluationType);

}
