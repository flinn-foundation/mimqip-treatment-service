package org.flinnfoundation.rules;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.flinnfoundation.model.Patient;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class R607aTest {

    private RulesEngine rulesEngine;
    private R607a r607a;

    private Patient patient;

    @Before
    public void setUp() {
        rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();
        r607a = new R607a();
        patient = new Patient();

        r607a.setPatient(patient);

        rulesEngine.registerRule(r607a);
    }

    @Test
    public void patientEvaluationIsNotRecentNoAction() {
        patient.setLastEvaluationDate(LocalDate.of(2007, 4, 12));
        rulesEngine.fireRules();

        assertTrue(patient.getMessageTags().isEmpty());
    }

    @Test
    public void patientEvaluation3DaysAgoNoAction() {
        patient.setLastEvaluationDate(LocalDate.now().minusDays(3));
        rulesEngine.fireRules();

        assertTrue(patient.getMessageTags().isEmpty());
    }

    @Test
    public void patientEvaluation2DaysAgoActionFires() {
        patient.setLastEvaluationDate(LocalDate.now().minusDays(2));
        rulesEngine.fireRules();

        assertEquals(R607a.MESSAGE_TAG, patient.getMessageTags().get(0));
    }


}
