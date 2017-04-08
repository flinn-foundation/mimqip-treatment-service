package org.flinnfoundation.model;

import org.flinnfoundation.model.enums.TreatmentGroupType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;


public class PatientTreatmentStatistics {

    private List<Treatment> patientTreatments;

    private Map<TreatmentGroupType, Integer> treatmentGroupTypeIntegerMap = new EnumMap<>(TreatmentGroupType.class);

    public PatientTreatmentStatistics(List<Treatment> patientTreatments) {
        this.patientTreatments = patientTreatments;

        for(TreatmentGroupType treatmentGroupType : TreatmentGroupType.values()) {
            calculateCount(treatmentGroupType);
        }
    }

    private void calculateCount(TreatmentGroupType treatmentGroupType) {

        int treatmentTypeCount = 0;

        for(Treatment treatment : patientTreatments) {
            if(treatment.getTreatmentGroup().getAbbreviation().equals(treatmentGroupType.toString())) {
                treatmentTypeCount++;
            }
        }

        treatmentGroupTypeIntegerMap.put(treatmentGroupType, treatmentTypeCount);
    }

    public int getCountForTreatmentGroupType(TreatmentGroupType treatmentGroupType) {
        return treatmentGroupTypeIntegerMap.get(treatmentGroupType);
    }

}
