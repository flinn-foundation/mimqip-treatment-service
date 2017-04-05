package org.flinnfoundation.model.diagnosis;

public class MajorDepressiveDisorder extends DiagnosisTemp {

    private static final String SOURCE = "Adapted from:  Suehs BT, Argo TR, Bendele SD, Crismon ML, Triedi MH, Krian B. Texas Medication Algorithm Project Procedural Manual: Major Depressive Disorder Algorithms. The Texas Department of State Health Services. 2008";

    MajorDepressiveDisorderType majorDepressiveDisorderType;

    public enum MajorDepressiveDisorderType {
        PSYCHOTIC, NON_PSYCHOTIC
    }
}
