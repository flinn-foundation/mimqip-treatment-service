package org.flinnfoundation.rules.generalmessage;

import org.flinnfoundation.model.enums.DiagnosisType;
import org.flinnfoundation.model.evaluation.EvaluationType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class R607aTest extends R607TestSetup {

    private R607a r607a = new R607a();

    @Before
    public void setUp() {
        super.setUp(r607a);
    }

    @Test
    public void patientEvaluationIsNotRecentReturnsFalse() {

        diagnosis.setDiagnosisType(DiagnosisType.MDD_R1);

        evaluation.setEvaluationType(DiagnosisType.MDD_R1.getEvaluationType());
        evaluation.setCreated(LocalDateTime.now().minusDays(8));

        assertFalse(r607a.when());
    }

    @Test
    public void patientEvaluation3DaysAgoReturnFalse() {
        diagnosis.setDiagnosisType(DiagnosisType.MDD_R1);

        evaluation.setEvaluationType(DiagnosisType.MDD_R1.getEvaluationType());
        evaluation.setCreated(LocalDateTime.now().minusDays(3));

        assertFalse(r607a.when());
    }

    @Test
    public void patientEvaluation2DaysAgoReturnsTrue() {
        diagnosis.setDiagnosisType(DiagnosisType.MDD_R1);

        evaluation.setEvaluationType(DiagnosisType.MDD_R1.getEvaluationType());
        evaluation.setCreated(LocalDateTime.now().minusDays(2));

        assertTrue(r607a.when());
    }

    @Test
    public void patientEvaluation2DaysAgoGlobalEvalReturnsTrue() {
        diagnosis.setDiagnosisType(DiagnosisType.MDD_R1);

        evaluation.setEvaluationType(EvaluationType.GLOBAL);
        evaluation.setCreated(LocalDateTime.now().minusDays(2));

        assertTrue(r607a.when());
    }

    @Test
    public void patientEvaluation2DaysAgoBipolarEvalReturnsFalse() {
        diagnosis.setDiagnosisType(DiagnosisType.MDD_R1);

        evaluation.setEvaluationType(DiagnosisType.SCHIZOPHRENIC_C.getEvaluationType());
        evaluation.setCreated(LocalDateTime.now().minusDays(2));

        assertFalse(r607a.when());
    }

    @Test
    public void patientEvaluationReturnsMessageTag() {
        r607a.then();
        assertEquals(R607a.MESSAGE_TAG,messageTags.get(0));
    }

}
