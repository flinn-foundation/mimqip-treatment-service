package org.flinnfoundation.model;

import lombok.Data;
import org.flinnfoundation.model.enums.DiagnosisType;

import java.util.Date;

@Data
public class Diagnosis {

    private long id;

    private Patient patient;

    private DiagnosisType diagnosisType;

    private String secondaryDiagnosis;

    private int stage;

    private Date createdTimestamp;
}
