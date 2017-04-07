package org.flinnfoundation.rules;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.flinnfoundation.model.Patient;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class R607bTest {

    private RulesEngine rulesEngine;
    private R607b r607b;

    private Patient patient;

    @Before
    public void setUp() {
        rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();
        r607b = new R607b();
        patient = new Patient();

        r607b.setPatient(patient);

        rulesEngine.registerRule(r607b);


    }

    @Test
    public void patientEvaluationIsNotRecentActionFires() {
        patient.setLastEvaluationDate(LocalDate.of(2007, 4, 12));
        rulesEngine.fireRules();

        assertEquals(R607b.MESSAGE_TAG, patient.getMessageTags().get(0));
    }

    @Test
    public void patientEvaluation3DaysAgoActionFires() {
        patient.setLastEvaluationDate(LocalDate.now().minusDays(3));
        rulesEngine.fireRules();

        assertEquals(R607b.MESSAGE_TAG, patient.getMessageTags().get(0));
    }

    @Test
    public void patientEvaluation2DaysAgoNoAction() {
        patient.setLastEvaluationDate(LocalDate.now().minusDays(2));
        rulesEngine.fireRules();

        assertTrue(patient.getMessageTags().isEmpty());
    }

}
