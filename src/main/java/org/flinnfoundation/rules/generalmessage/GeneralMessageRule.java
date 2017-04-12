package org.flinnfoundation.rules.generalmessage;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.model.enums.DiagnosisType;
import org.flinnfoundation.model.evaluation.Evaluation;
import org.flinnfoundation.model.evaluation.EvaluationType;
import org.flinnfoundation.rules.AbstractBaseRule;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class GeneralMessageRule extends AbstractBaseRule {

    protected Patient patient;
    protected List<Evaluation> evaluations;

    protected boolean hasRecentRelatedEvaluation() {
        LocalDateTime threeDaysAgo = LocalDateTime.now().minusDays(3);
        DiagnosisType diagnosis = patient.getDiagnosisType();

        EvaluationType diagnosisEvaluationType = diagnosis.getEvaluationType();

        List<Evaluation> qualifyingEvaluations = new ArrayList<>();
        for (Evaluation evaluation : evaluations) {
            if(evaluation.getEvaluationType().equals(EvaluationType.GLOBAL) || evaluation.getEvaluationType().equals(diagnosisEvaluationType)) {
                qualifyingEvaluations.add(evaluation);
            }
        }

        boolean foundQualifyingEvaluation = false;
        for(Evaluation evaluation : qualifyingEvaluations) {
            if(evaluation.getCreated().isAfter(threeDaysAgo)) {
                foundQualifyingEvaluation = true;
            }
        }

        return foundQualifyingEvaluation;
    }
}
