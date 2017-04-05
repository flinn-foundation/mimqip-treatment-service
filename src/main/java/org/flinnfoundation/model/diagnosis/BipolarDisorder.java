package org.flinnfoundation.model.diagnosis;

public class BipolarDisorder extends DiagnosisTemp {

    private static final String SOURCE = "Adapted from: Crismon ML, Argo TR, Bendele SD, Suppes T. Texas Medication Algorithm Project Procedural Manual: Bipolar Disorder Algorithms. The Texas Department of State Health Services. 2007";

    private BipolarType bipolarType;

    public enum BipolarType {
        MANIC, DEPRESSED
    }
}
