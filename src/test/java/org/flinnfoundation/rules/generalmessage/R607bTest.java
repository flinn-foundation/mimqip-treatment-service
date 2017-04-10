package org.flinnfoundation.rules.generalmessage;

import org.flinnfoundation.model.enums.DiagnosisType;
import org.flinnfoundation.model.evaluation.EvaluationType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class R607bTest extends R607TestSetup {

    private R607b r607b = new R607b();

    @Before
    public void setUp() {
        super.setUp(r607b);
    }

    @Test
    public void patientEvaluationIsNotRecentActionFires() {

        diagnosis.setDiagnosisType(DiagnosisType.MDD_NP);

        evaluation.setEvaluationType(EvaluationType.PHQ9);
        evaluation.setCreated(LocalDateTime.now().minusDays(8));

        rulesEngine.fireRules();

        assertEquals(R607b.MESSAGE_TAG, messageTags.get(0));
    }

    @Test
    public void patientEvaluation3DaysAgoActionFires() {
        diagnosis.setDiagnosisType(DiagnosisType.MDD_NP);

        evaluation.setEvaluationType(EvaluationType.PHQ9);
        evaluation.setCreated(LocalDateTime.now().minusDays(3));

        rulesEngine.fireRules();

        assertEquals(R607b.MESSAGE_TAG, messageTags.get(0));
    }

    @Test
    public void patientEvaluation2DaysAgoNoAction() {
        diagnosis.setDiagnosisType(DiagnosisType.MDD_NP);

        evaluation.setEvaluationType(EvaluationType.PHQ9);
        evaluation.setCreated(LocalDateTime.now().minusDays(2));

        rulesEngine.fireRules();

        assertTrue(messageTags.isEmpty());
    }

}
