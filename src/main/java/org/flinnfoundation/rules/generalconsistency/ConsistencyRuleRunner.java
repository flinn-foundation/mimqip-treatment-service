package org.flinnfoundation.rules.generalconsistency;

import org.flinnfoundation.model.DiagnosisOld;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.model.enums.DiagnosisType;
import org.flinnfoundation.respository.DiagnosisRepository;
import org.flinnfoundation.rules.AbstractBaseRule;
import org.flinnfoundation.rules.AbstractBaseRuleRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ConsistencyRuleRunner extends AbstractBaseRuleRunner {

    //TODO: having this be static scares me a bit maybe make the runRules method synchronized
    private static List<AbstractBaseRule> rules = Arrays.asList(new R101(), new R102());

    private DiagnosisRepository diagnosisRepository;

    @Autowired
    public ConsistencyRuleRunner(DiagnosisRepository diagnosisRepository) {
        super(rules);

        this.diagnosisRepository = diagnosisRepository;
    }

    @Override
    public List<String> runRules(Patient patient) {

        DiagnosisType patientDiagnosis = patient.getDiagnosis().getDiagnosisType();
        List<DiagnosisOld> higherStageDiagnosis = diagnosisRepository.findDiagnosesByDiagnosisTypeAndStageGreaterThan(patientDiagnosis, patientDiagnosis.getStage().ordinal());
        List<DiagnosisOld> lowerStageDiagnosis = diagnosisRepository.findDiagnosesByDiagnosisTypeAndStageLessThan(patientDiagnosis, patientDiagnosis.getStage().ordinal());

        List<String> messageTags = new ArrayList<>();
        for(AbstractBaseRule rule : rules) {
            ((ConsistencyRule) rule).setPatient(patient);
            rule.setMessageTags(messageTags);
        }

        rulesEngine.fireRules();

        return messageTags;
    }
}
