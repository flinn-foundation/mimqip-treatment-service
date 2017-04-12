package org.flinnfoundation.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.flinnfoundation.model.evaluation.EvaluationType;

@Getter
@AllArgsConstructor
public enum DiagnosisType {
    SCHIZOPHRENIC_P(MajorDiagnosis.SCHIZOPHRENIC, SchizophreniaMinorDiagnosis.PARANOID, Stage.UNSPECIFIED,  "295.30", "F20.0", "Paranoid schizophrenia", EvaluationType.PSRS),
    SCHIZOPHRENIC_D(MajorDiagnosis.SCHIZOPHRENIC, SchizophreniaMinorDiagnosis.DISORGANIZED, Stage.UNSPECIFIED, "295.10", "F20.1", "Disorganized schizophrenia", EvaluationType.PSRS),
    SCHIZOPHRENIC_C(MajorDiagnosis.SCHIZOPHRENIC, SchizophreniaMinorDiagnosis.CATATONIC, Stage.UNSPECIFIED, "295.20", "F20.2", "Catatonic schizophrenia", EvaluationType.PSRS),
    SCHIZOPHRENIC_U(MajorDiagnosis.SCHIZOPHRENIC, SchizophreniaMinorDiagnosis.UNDIFFERENTIATED, Stage.UNSPECIFIED, "295.90", "F20.3", "Undifferentiated schizophrenia", EvaluationType.PSRS),
    SCHIZOPHRENIC_R(MajorDiagnosis.SCHIZOPHRENIC, SchizophreniaMinorDiagnosis.RESIDUAL, Stage.UNSPECIFIED, "295.60", "F20.5", "Residual schizophrenia", EvaluationType.PSRS),
    BIPOLAR_SM1(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.SINGLE_MANIC, Stage.MILD, "296.01", "F30.11", "Manic episode without psychotic symptoms, mild", EvaluationType.BBDSS),
    BIPOLAR_SM2(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.SINGLE_MANIC, Stage.MODERATE, "296.02", "F30.12", "Manic episode without psychotic symptoms, moderate", EvaluationType.BBDSS),
    BIPOLAR_SM3(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.SINGLE_MANIC, Stage.SEVERE_NON_PSYCHOTIC, "296.03", "F30.13", "Manic episode without psychotic symptoms, severe", EvaluationType.BBDSS),
    BIPOLAR_SM4(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.SINGLE_MANIC, Stage.SEVERE_PSYCHOTIC, "296.04", "F30.2", "Manic episode, severe with psychotic symptoms", EvaluationType.BBDSS),
    BIPOLAR_MRMH(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.MOST_RECENT_HYPOMANIC, Stage.UNSPECIFIED, "296.40", "F31.10", "Bipolar disorder, current episode manic without psychotic features, unspecified", EvaluationType.BBDSS),
    BIPOLAR_MRM1(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.MOST_RECENT_MANIC, Stage.MILD,"296.41", "F31.11", "Bipolar disorder, current episode manic without psychotic features, mild", EvaluationType.BBDSS),
    BIPOLAR_MRM2(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.MOST_RECENT_MANIC, Stage.MODERATE,"296.42", "F31.12", "Bipolar disorder, current episode manic without psychotic features, moderate", EvaluationType.BBDSS),
    BIPOLAR_MRM3(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.MOST_RECENT_MANIC, Stage.SEVERE_NON_PSYCHOTIC,"296.43", "F31.13", "Bipolar disorder, current episode manic without psychotic features, severe", EvaluationType.BBDSS),
    BIPOLAR_MRM4(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.MOST_RECENT_MANIC, Stage.SEVERE_PSYCHOTIC,"296.44", "F31.2", "Bipolar disorder, current episode manic severe with psychotic features", EvaluationType.BBDSS),
    BIPOLAR_MRD1(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.MOST_RECENT_DEPRESSED, Stage.MILD,"296.51", "F31.31", "Bipolar disorder, current episode depressed, mild", EvaluationType.BBDSS),
    BIPOLAR_MRD2(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.MOST_RECENT_DEPRESSED, Stage.MODERATE,"296.52", "F31.32", "Bipolar disorder, current episode depressed, moderate", EvaluationType.BBDSS),
    BIPOLAR_MRD3(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.MOST_RECENT_DEPRESSED, Stage.SEVERE_NON_PSYCHOTIC,"296.53", "F31.4", "Bipolar disorder, current episode depressed, severe, without psychotic features", EvaluationType.BBDSS),
    BIPOLAR_MRD4(MajorDiagnosis.BIPOLAR, BipolarMinorDiagnosis.MOST_RECENT_DEPRESSED, Stage.SEVERE_PSYCHOTIC,"296.54", "F31.5", "Bipolar disorder, current episode depressed, severe, with psychotic features", EvaluationType.BBDSS),
    MDD_S1(MajorDiagnosis.MDD, MDDMinorDiagnosis.SINGLE, Stage.MILD, "296.21", "F32.0", "Major depressive disorder, single episode, mild", EvaluationType.PHQ9),
    MDD_S2(MajorDiagnosis.MDD, MDDMinorDiagnosis.SINGLE, Stage.MODERATE, "296.22", "F32.1", "Major depressive disorder, single episode, moderate", EvaluationType.PHQ9),
    MDD_S3(MajorDiagnosis.MDD, MDDMinorDiagnosis.SINGLE, Stage.SEVERE_NON_PSYCHOTIC, "296.23", "F32.2", "Major depressive disorder, single episode, severe without psychotic features", EvaluationType.PHQ9),
    MDD_S4(MajorDiagnosis.MDD, MDDMinorDiagnosis.SINGLE, Stage.SEVERE_PSYCHOTIC, "296.24", "F32.3", "Major depressive disorder, single episode, severe with psychotic features", EvaluationType.PHQ9),
    MDD_R1(MajorDiagnosis.MDD, MDDMinorDiagnosis.RECURRENT, Stage.MILD, "296.31", "F33.0", "Major depressive disorder, recurrent, mild", EvaluationType.PHQ9),
    MDD_R2(MajorDiagnosis.MDD, MDDMinorDiagnosis.RECURRENT, Stage.MODERATE, "296.32", "F33.1", "Major depressive disorder, recurrent, moderate", EvaluationType.PHQ9),
    MDD_R3(MajorDiagnosis.MDD, MDDMinorDiagnosis.RECURRENT, Stage.SEVERE_NON_PSYCHOTIC, "296.33", "F33.2", "Major depressive disorder, recurrent severe without psychotic features", EvaluationType.PHQ9),
    MDD_R4(MajorDiagnosis.MDD, MDDMinorDiagnosis.RECURRENT, Stage.SEVERE_PSYCHOTIC, "296.34", "F33.3", "Major depressive disorder, recurrent, severe with psychotic symptoms", EvaluationType.PHQ9);

    private MajorDiagnosis majorDiagnosis;
    private MinorDiagnosis minorDiagnosis;
    private Stage stage;

    private String icd9Code;
    private String icd10Code;
    private String icd10description;

    private EvaluationType evaluationType;

    public enum MajorDiagnosis {
        MDD, BIPOLAR, SCHIZOPHRENIC
    }

    interface MinorDiagnosis {

    }

    public enum SchizophreniaMinorDiagnosis implements MinorDiagnosis {
        DISORGANIZED, CATATONIC, PARANOID, RESIDUAL, UNDIFFERENTIATED
    }

    public enum BipolarMinorDiagnosis implements MinorDiagnosis {
        SINGLE_MANIC, MOST_RECENT_HYPOMANIC, MOST_RECENT_MANIC, MOST_RECENT_DEPRESSED

    }

    public enum MDDMinorDiagnosis implements MinorDiagnosis {
        SINGLE, RECURRENT
    }

    public enum Stage {
        UNSPECIFIED, MILD, MODERATE, SEVERE_NON_PSYCHOTIC, SEVERE_PSYCHOTIC
    }
}
