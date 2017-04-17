package org.flinnfoundation.rules.generalmessage;

import org.flinnfoundation.model.Diagnosis;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.model.evaluation.Evaluation;

import java.util.ArrayList;
import java.util.List;

public class R607TestSetup {

    Diagnosis diagnosis = new Diagnosis();
    Evaluation evaluation = new Evaluation();

    Patient patient = new Patient();
    List<Evaluation> evaluations = new ArrayList<>();
    List<String> messageTags = new ArrayList<>();

    public void setUp(GeneralMessageRule rule) {

        patient.setDiagnosis(diagnosis);
        evaluations.add(evaluation);
        patient.setEvaluations(evaluations);

        rule.setPatient(patient);
        rule.setMessageTags(messageTags);

    }
}
