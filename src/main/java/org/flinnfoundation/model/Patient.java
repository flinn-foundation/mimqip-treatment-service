package org.flinnfoundation.model;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class Patient {

    private long id;

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
