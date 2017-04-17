package org.flinnfoundation.service;

import org.flinnfoundation.model.PatientMedication;

import java.util.List;

public interface PatientMedicationService {


    List<PatientMedication> getMedications(long patientId);

}
