package org.flinnfoundation.rules.generalmessage;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.flinnfoundation.model.Diagnosis;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.model.evaluation.Evaluation;
import org.flinnfoundation.model.evaluation.EvaluationType;
import org.flinnfoundation.rules.AbstractBaseRule;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class GeneralMessageRule extends AbstractBaseRule {

    protected Patient patient;

    boolean hasRecentRelatedEvaluation() {
        OffsetDateTime threeDaysAgo = OffsetDateTime.now().minusDays(3);
        Diagnosis diagnosis = patient.getDiagnosis();

        if (diagnosis == null) {
            return false;
        }

        EvaluationType diagnosisEvaluationType = diagnosis.getDiagnosisType().getEvaluationType();

        List<Evaluation> qualifyingEvaluations = new ArrayList<>();
        for (Evaluation evaluation : patient.getEvaluations()) {
            if (evaluation.getEvaluationType().equals(EvaluationType.GLOBAL) || evaluation.getEvaluationType().equals(diagnosisEvaluationType)) {
                qualifyingEvaluations.add(evaluation);
            }
        }

        boolean foundQualifyingEvaluation = false;
        for (Evaluation evaluation : qualifyingEvaluations) {
            if (evaluation.getCreated().isAfter(threeDaysAgo)) {
                foundQualifyingEvaluation = true;
                break;
            }
        }

        return foundQualifyingEvaluation;
    }
}
