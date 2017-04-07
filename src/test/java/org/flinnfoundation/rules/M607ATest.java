package org.flinnfoundation.rules;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.flinnfoundation.fact.Patient;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class M607ATest {

    private RulesEngine rulesEngine;
    private M607a m607a;

    private Patient patient;
    private List<String> activeRules;

    @Before
    public void setUp() {
        rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();
        m607a = new M607a();
        patient = new Patient();
        activeRules = new ArrayList<>();

        m607a.setPatient(patient);
        m607a.setActiveRules(activeRules);

        rulesEngine.registerRule(m607a);


    }

    @Test
    public void testOldEvaluationPatient() {
        patient.setLastEvaluationDate(LocalDate.of(2007, 4, 12));
        rulesEngine.fireRules();

    }

    @Test
    public void testNewEvaluationPatient() {
        patient.setLastEvaluationDate(LocalDate.now());
        rulesEngine.fireRules();

        System.out.println(m607a.getActiveRules());

    }

}
