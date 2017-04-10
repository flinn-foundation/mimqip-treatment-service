package org.flinnfoundation.rulerunner;

import org.flinnfoundation.model.Patient;
import org.flinnfoundation.model.PatientTreatmentStatistics;
import org.flinnfoundation.model.Treatment;
import org.flinnfoundation.respository.TreatmentRepository;
import org.flinnfoundation.rules.AbstractBaseRule;
import org.flinnfoundation.rules.generalpharmacological.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PharmacologicalRuleRunner extends AbstractBaseRuleRunner {

    //TODO: having this be static scares me a bit maybe make the evaluate method synchronized
    private static List<AbstractBaseRule> rules = Arrays.asList(new R301(), new R302(), new R303(), new R304(), new R305(), new R306(), new R307());

    private TreatmentRepository treatmentRepository;

    @Autowired
    public PharmacologicalRuleRunner(TreatmentRepository treatmentRepository) {
        super(rules);
        this.treatmentRepository = treatmentRepository;

    }

    public List<String> evaluate(Patient patient) {

        List<Treatment> activeTreatments = treatmentRepository.getTreatmentsByGenericName(patient.getActiveMedicationGenericNames());
        PatientTreatmentStatistics patientTreatmentStatistics = new PatientTreatmentStatistics(activeTreatments);

        List<String> messageTags = new ArrayList<>();
        for (AbstractBaseRule pharmacologicalRule : rules) {
            ((PharmacologicalRule) pharmacologicalRule).setTreatmentStatistics(patientTreatmentStatistics);
            pharmacologicalRule.setMessageTags(messageTags);
        }
        rulesEngine.fireRules();

        return messageTags;
    }
}
