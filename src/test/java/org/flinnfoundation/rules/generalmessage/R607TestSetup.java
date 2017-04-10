package org.flinnfoundation.rules.generalmessage;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.flinnfoundation.model.Diagnosis;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.model.evaluation.Evaluation;

import java.util.ArrayList;
import java.util.List;

public class R607TestSetup {

    protected RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();

    protected Diagnosis diagnosis = new Diagnosis();
    protected Evaluation evaluation = new Evaluation();

    protected Patient patient = new Patient();
    protected List<Evaluation> evaluations = new ArrayList<>();
    protected List<String> messageTags = new ArrayList<>();

    public void setUp(GeneralMessageRule rule) {

        patient.setDiagnosis(diagnosis);
        evaluations.add(evaluation);

        rule.setPatient(patient);
        rule.setEvaluations(evaluations);
        rule.setMessageTags(messageTags);

        rulesEngine.registerRule(rule);
    }
}
