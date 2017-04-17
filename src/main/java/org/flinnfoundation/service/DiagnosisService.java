package org.flinnfoundation.service;


import org.flinnfoundation.model.Diagnosis;

import java.util.List;

public interface DiagnosisService {

    Diagnosis getLatestDiagnosis(long patientId);

    List<Diagnosis> getDiagnoses(long patientId);

}
