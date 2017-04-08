package org.flinnfoundation.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class Patient {

    private LocalDate lastEvaluationDate;

    private List<PatientMedication> patientMedications;

    private Diagnosis diagnosis;

    public Set<String> getActiveMedicationGenericNames() {
        Set<String> activePatientGenericTreatmentNames = new HashSet<>();
        for(PatientMedication patientMedication : patientMedications) {
            if(!patientMedication.isDeletedFlag()) {
                activePatientGenericTreatmentNames.add(patientMedication.getGenericName());
            }
        }

        return activePatientGenericTreatmentNames;
    }
}
