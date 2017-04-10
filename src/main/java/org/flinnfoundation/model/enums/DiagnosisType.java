package org.flinnfoundation.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.flinnfoundation.model.evaluation.EvaluationType;


@Getter
@AllArgsConstructor
public enum  DiagnosisType {
    MDD_NP(MajorDiagnosis.MDD, MDDMinorDiagnosis.NON_PSYCHOTIC, EvaluationType.PHQ9),
    MDD_P(MajorDiagnosis.MDD, MDDMinorDiagnosis.PSYCHOTIC, EvaluationType.PHQ9),
    BIPOLAR_M(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.MANIC, EvaluationType.BBDSS),
    BIPOLAR_D(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.DEPRESSED, EvaluationType.BBDSS),
    SCHIZOPHRENIC(MajorDiagnosis.SCHIZOPHRENIC, null, EvaluationType.PSRS);

    private MajorDiagnosis majorDiagnosis;
    private MinorDiagnosis minorDiagnosis;
    private EvaluationType evaluationType;


    public enum MajorDiagnosis {
        MDD, BIPOLAR, SCHIZOPHRENIC
    }

    interface MinorDiagnosis {

    }

    public enum MDDMinorDiagnosis implements MinorDiagnosis {
        PSYCHOTIC, NON_PSYCHOTIC
    }

    public enum BipolarMinorDiagnosis implements MinorDiagnosis {
        MANIC, DEPRESSED
    }


}
