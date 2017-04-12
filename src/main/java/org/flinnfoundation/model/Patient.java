package org.flinnfoundation.model;

import lombok.Data;
import org.flinnfoundation.model.enums.DiagnosisType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class Patient {

    private long id;

    private List<PatientMedication> patientMedications;

    private DiagnosisType diagnosisType;

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
