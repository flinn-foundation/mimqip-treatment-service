package org.flinnfoundation.rules.generalmessage;

import org.flinnfoundation.model.enums.DiagnosisType;
import org.flinnfoundation.model.evaluation.EvaluationType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class R607aTest extends R607TestSetup {

    private R607a r607a = new R607a();

    @Before
    public void setUp() {
        super.setUp(r607a);
    }

    @Test
    public void patientEvaluationIsNotRecentNoAction() {

        diagnosis.setDiagnosisType(DiagnosisType.MDD_NP);

        evaluation.setEvaluationType(EvaluationType.PHQ9);
        evaluation.setCreated(LocalDateTime.now().minusDays(8));

        rulesEngine.fireRules();

        assertTrue(messageTags.isEmpty());
    }

    @Test
    public void patientEvaluation3DaysAgoNoAction() {
        diagnosis.setDiagnosisType(DiagnosisType.MDD_NP);

        evaluation.setEvaluationType(EvaluationType.PHQ9);
        evaluation.setCreated(LocalDateTime.now().minusDays(3));

        rulesEngine.fireRules();

        assertTrue(messageTags.isEmpty());
    }

    @Test
    public void patientEvaluation2DaysAgoActionFires() {
        diagnosis.setDiagnosisType(DiagnosisType.MDD_NP);

        evaluation.setEvaluationType(EvaluationType.PHQ9);
        evaluation.setCreated(LocalDateTime.now().minusDays(2));

        rulesEngine.fireRules();

        assertEquals(R607a.MESSAGE_TAG, messageTags.get(0));
    }


}
