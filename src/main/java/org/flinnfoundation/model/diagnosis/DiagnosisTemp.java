package org.flinnfoundation.model.diagnosis;

import org.flinnfoundation.model.Treatment;

import java.util.Arrays;
import java.util.List;

public class DiagnosisTemp {

    private static final List<Integer> STAGES = Arrays.asList(1,2,3,4);

    private int stage;
    private String source;
    private List<Treatment> treatments;


}
