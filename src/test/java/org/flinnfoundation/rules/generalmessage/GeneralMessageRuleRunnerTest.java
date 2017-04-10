package org.flinnfoundation.rules.generalmessage;

import org.flinnfoundation.model.Diagnosis;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.model.enums.DiagnosisType;
import org.flinnfoundation.model.evaluation.Evaluation;
import org.flinnfoundation.model.evaluation.EvaluationType;
import org.flinnfoundation.service.EvaluationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GeneralMessageRuleRunnerTest {

    @Mock
    private EvaluationService evaluationService;

    private Evaluation evaluation = new Evaluation();
    private Diagnosis diagnosis = new Diagnosis();
    private Patient patient = new Patient();

    private List<Evaluation> evaluations = new ArrayList<>();

    @InjectMocks
    private GeneralMessageRuleRunner generalMessageRuleRunner;

    @Before
    public void setUp() throws Exception {

        diagnosis.setDiagnosisType(DiagnosisType.SCHIZOPHRENIC);
        patient.setDiagnosis(diagnosis);
        evaluations.add(evaluation);

        when(evaluationService.getEvaluations(patient)).thenReturn(evaluations);
    }

    @Test
    public void runRulesWithEmptyEvaluationsReturnsNeedEval() throws Exception {
        evaluations.clear();
        assertEquals(Arrays.asList(R607b.MESSAGE_TAG),generalMessageRuleRunner.runRules(patient));
    }

    @Test
    public void runRulesWithEvaluationsNotMatchingDiagnosisReturnsNeedEval() throws Exception {


        evaluation.setEvaluationType(DiagnosisType.BIPOLAR_D.getEvaluationType());
        evaluation.setCreated(LocalDateTime.now());

        assertEquals(Arrays.asList(R607b.MESSAGE_TAG),generalMessageRuleRunner.runRules(patient));
    }

    @Test
    public void runRulesWithOldEvaluationsReturnsNeedEval() throws Exception {

        evaluation.setEvaluationType(DiagnosisType.SCHIZOPHRENIC.getEvaluationType());
        evaluation.setCreated(LocalDateTime.now().minusDays(4));

        assertEquals(Arrays.asList(R607b.MESSAGE_TAG),generalMessageRuleRunner.runRules(patient));
    }

    @Test
    public void runRulesWithRecentGlobalEvaluationReturnsNeedEval() throws Exception {

        evaluation.setEvaluationType(EvaluationType.GLOBAL);
        evaluation.setCreated(LocalDateTime.now().minusDays(3));

        assertEquals(Arrays.asList(R607b.MESSAGE_TAG),generalMessageRuleRunner.runRules(patient));
    }

    @Test
    public void runRulesWithRecentEvaluationsReturnsValidEval() throws Exception {

        evaluation.setEvaluationType(DiagnosisType.SCHIZOPHRENIC.getEvaluationType());
        evaluation.setCreated(LocalDateTime.now().minusDays(2));

        assertEquals(Arrays.asList(R607a.MESSAGE_TAG),generalMessageRuleRunner.runRules(patient));
    }

    @Test
    public void runRulesWithRecentGlobalEvaluationReturnsValidEval() throws Exception {

        evaluation.setEvaluationType(EvaluationType.GLOBAL);
        evaluation.setCreated(LocalDateTime.now().minusDays(2));

        assertEquals(Arrays.asList(R607a.MESSAGE_TAG),generalMessageRuleRunner.runRules(patient));
    }

}
