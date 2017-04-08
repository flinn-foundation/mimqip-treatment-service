package org.flinnfoundation.evaluators;

import org.flinnfoundation.model.Diagnosis;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.respository.DiagnosisRepository;
import org.flinnfoundation.rules.AbstractBaseRule;
import org.flinnfoundation.rules.generalconsistency.ConsistencyRule;
import org.flinnfoundation.rules.generalconsistency.R101;
import org.flinnfoundation.rules.generalconsistency.R102;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ConsistencyRuleEvaluator extends AbstractBaseRuleEvaluator {

    //TODO: having this be static scares me a bit maybe make the evaluate method synchronized
    private static List<AbstractBaseRule> rules = Arrays.asList(new R101(), new R102());

    private DiagnosisRepository diagnosisRepository;

    @Autowired
    public ConsistencyRuleEvaluator(DiagnosisRepository diagnosisRepository) {
        super(rules);

        this.diagnosisRepository = diagnosisRepository;
    }

    @Override
    public List<String> evaluate(Patient patient) {

        Diagnosis patientDiagnosis = patient.getDiagnosis();
        List<Diagnosis> higherStageDiagnosis = diagnosisRepository.findDiagnosesByDiagnosisTypeAndStageGreaterThan(patientDiagnosis.getDiagnosisType(), patientDiagnosis.getStage());
        List<Diagnosis> lowerStageDiagnosis = diagnosisRepository.findDiagnosesByDiagnosisTypeAndStageLessThan(patientDiagnosis.getDiagnosisType(), patientDiagnosis.getStage());

        List<String> messageTags = new ArrayList<>();
        for(AbstractBaseRule rule : rules) {
            ((ConsistencyRule) rule).setPatient(patient);
            rule.setMessageTags(messageTags);
        }

        rulesEngine.fireRules();

        return messageTags;
    }
}
