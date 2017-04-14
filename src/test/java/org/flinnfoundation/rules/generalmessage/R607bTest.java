package org.flinnfoundation.rules.generalmessage;

import org.flinnfoundation.model.enums.DiagnosisType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.TestCase.assertFalse;
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

        diagnosis.setDiagnosisType(DiagnosisType.MDD_R1);

        evaluation.setEvaluationType(DiagnosisType.MDD_R1.getEvaluationType());
        evaluation.setCreated(LocalDateTime.now().minusDays(8));

        assertTrue(r607b.when());
    }

    @Test
    public void patientEvaluation3DaysAgoActionFires() {
        diagnosis.setDiagnosisType(DiagnosisType.MDD_R1);

        evaluation.setEvaluationType(DiagnosisType.MDD_R1.getEvaluationType());
        evaluation.setCreated(LocalDateTime.now().minusDays(3));

        assertTrue(r607b.when());
    }

    @Test
    public void patientEvaluation2DaysAgoNoAction() {
        diagnosis.setDiagnosisType(DiagnosisType.MDD_R1);

        evaluation.setEvaluationType(DiagnosisType.MDD_R1.getEvaluationType());
        evaluation.setCreated(LocalDateTime.now().minusDays(2));

        assertFalse(r607b.when());
    }

    @Test
    public void patientEvaluationReturnsMessageTag() {
        r607b.then();
        assertEquals(R607b.MESSAGE_TAG,messageTags.get(0));
    }

}
