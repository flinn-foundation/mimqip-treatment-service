package org.flinnfoundation.rules.generalmessage;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.flinnfoundation.model.Patient;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class R607aTest {

    private RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();
    private R607a r607a = new R607a();

    private Patient patient = new Patient();
    private List<String> messageTags = new ArrayList<>();

    @Before
    public void setUp() {

        r607a.setPatient(patient);
        r607a.setMessageTags(messageTags);

        rulesEngine.registerRule(r607a);
    }

    @Test
    public void patientEvaluationIsNotRecentNoAction() {
        patient.setLastEvaluationDate(LocalDate.of(2007, 4, 12));
        rulesEngine.fireRules();

        assertTrue(messageTags.isEmpty());
    }

    @Test
    public void patientEvaluation3DaysAgoNoAction() {
        patient.setLastEvaluationDate(LocalDate.now().minusDays(3));
        rulesEngine.fireRules();

        assertTrue(messageTags.isEmpty());
    }

    @Test
    public void patientEvaluation2DaysAgoActionFires() {
        patient.setLastEvaluationDate(LocalDate.now().minusDays(2));
        rulesEngine.fireRules();

        assertEquals(R607a.MESSAGE_TAG, messageTags.get(0));
    }


}
