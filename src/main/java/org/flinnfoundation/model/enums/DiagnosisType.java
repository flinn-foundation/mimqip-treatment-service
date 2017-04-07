package org.flinnfoundation.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  DiagnosisType {
    MDD_NP(MajorDiagnosis.MDD, MDDMinorDiagnosis.NONPSYCHOTIC),
    MDD_P(MajorDiagnosis.MDD, MDDMinorDiagnosis.PSYCHOTIC),
    BIPOLAR_M(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.MANIC),
    BIPOLAR_D(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.DEPRESSED),
    SCHIZOPHRENIC(MajorDiagnosis.SCHIZOPHRENIC, null);

    private MajorDiagnosis majorDiagnosis;
    private MinorDiagnosis minorDiagnosis;


    public enum MajorDiagnosis {
        MDD, BIPOLAR, SCHIZOPHRENIC
    }

    interface MinorDiagnosis {

    }

    public enum MDDMinorDiagnosis implements MinorDiagnosis {
        PSYCHOTIC, NONPSYCHOTIC
    }

    public enum BipolarMinorDiagnosis implements MinorDiagnosis {
        MANIC, DEPRESSED
    }


}
