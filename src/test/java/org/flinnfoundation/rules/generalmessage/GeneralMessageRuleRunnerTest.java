package org.flinnfoundation.rules.generalmessage;

import org.flinnfoundation.model.Diagnosis;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.model.enums.DiagnosisType;
import org.flinnfoundation.model.evaluation.Evaluation;
import org.flinnfoundation.model.evaluation.EvaluationType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GeneralMessageRuleRunnerTest {

    private Evaluation evaluation = new Evaluation();
    private Diagnosis diagnosis = new Diagnosis();
    private Patient patient = new Patient();

    private List<Evaluation> evaluations = new ArrayList<>();

    @InjectMocks
    private GeneralMessageRuleRunner generalMessageRuleRunner;

    @Before
    public void setUp() throws Exception {

        diagnosis.setDiagnosisType(DiagnosisType.SCHIZOPHRENIC_C);
        patient.setDiagnosis(diagnosis);
        evaluations.add(evaluation);
        patient.setEvaluations(evaluations);
    }

    @Test
    public void runRulesWithEmptyDiagnosisReturnsNeedEval() throws Exception {
        patient.setDiagnosis(null);
        assertEquals(Arrays.asList(R607b.MESSAGE_TAG), generalMessageRuleRunner.runRules(patient));
    }

    @Test
    public void runRulesWithEmptyEvaluationsReturnsNeedEval() throws Exception {
        evaluations.clear();
        assertEquals(Arrays.asList(R607b.MESSAGE_TAG),generalMessageRuleRunner.runRules(patient));
    }

    @Test
    public void runRulesWithEvaluationsNotMatchingDiagnosisReturnsNeedEval() throws Exception {


        evaluation.setEvaluationType(DiagnosisType.BIPOLAR_MRD1.getEvaluationType());
        evaluation.setCreated(OffsetDateTime.now());

        assertEquals(Arrays.asList(R607b.MESSAGE_TAG),generalMessageRuleRunner.runRules(patient));
    }

    @Test
    public void runRulesWithOldEvaluationsReturnsNeedEval() throws Exception {

        evaluation.setEvaluationType(DiagnosisType.SCHIZOPHRENIC_C.getEvaluationType());
        evaluation.setCreated(OffsetDateTime.now().minusDays(4));

        assertEquals(Arrays.asList(R607b.MESSAGE_TAG),generalMessageRuleRunner.runRules(patient));
    }

    @Test
    public void runRulesWithRecentGlobalEvaluationReturnsNeedEval() throws Exception {

        evaluation.setEvaluationType(EvaluationType.GLOBAL);
        evaluation.setCreated(OffsetDateTime.now().minusDays(3));

        assertEquals(Arrays.asList(R607b.MESSAGE_TAG),generalMessageRuleRunner.runRules(patient));
    }

    @Test
    public void runRulesWithRecentEvaluationsReturnsValidEval() throws Exception {

        evaluation.setEvaluationType(DiagnosisType.SCHIZOPHRENIC_C.getEvaluationType());
        evaluation.setCreated(OffsetDateTime.now().minusDays(2));

        assertEquals(Arrays.asList(R607a.MESSAGE_TAG),generalMessageRuleRunner.runRules(patient));
    }

    @Test
    public void runRulesWithRecentGlobalEvaluationReturnsValidEval() throws Exception {

        evaluation.setEvaluationType(EvaluationType.GLOBAL);
        evaluation.setCreated(OffsetDateTime.now().minusDays(2));

        assertEquals(Arrays.asList(R607a.MESSAGE_TAG),generalMessageRuleRunner.runRules(patient));
    }

}
