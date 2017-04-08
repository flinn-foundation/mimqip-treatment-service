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

public class R607bTest {

    private RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();
    private R607b r607b = new R607b();

    private Patient patient = new Patient();
    private List<String> messageTags = new ArrayList<>();

    @Before
    public void setUp() {

        r607b.setPatient(patient);
        r607b.setMessageTags(messageTags);

        rulesEngine.registerRule(r607b);
    }

    @Test
    public void patientEvaluationIsNotRecentActionFires() {
        patient.setLastEvaluationDate(LocalDate.of(2007, 4, 12));
        rulesEngine.fireRules();

        assertEquals(R607b.MESSAGE_TAG, messageTags.get(0));
    }

    @Test
    public void patientEvaluation3DaysAgoActionFires() {
        patient.setLastEvaluationDate(LocalDate.now().minusDays(3));
        rulesEngine.fireRules();

        assertEquals(R607b.MESSAGE_TAG, messageTags.get(0));
    }

    @Test
    public void patientEvaluation2DaysAgoNoAction() {
        patient.setLastEvaluationDate(LocalDate.now().minusDays(2));
        rulesEngine.fireRules();

        assertTrue(messageTags.isEmpty());
    }

}
