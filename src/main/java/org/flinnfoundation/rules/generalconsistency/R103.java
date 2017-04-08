package org.flinnfoundation.rules.generalconsistency;

import lombok.Data;
import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Data
@Rule(name = R103.RULE)
public class R103 extends ConsistencyRule{

    static final String RULE = "R103";
    static final String MESSAGE_TAG = "M103";

    @Condition
    public boolean when() {

        /*IF there is an exact match between the patient drug set and the guideline drug set for any stage
           of treatment below the patient&#39;s current stage: THEN
        */
//        Diagnosis diagnosis = patient.getDiagnosis();
//        List<Treatment> guidelineTreatments = diagnosis.getTreatments();
//
//        List<Treatment> patientTreatments = patient.getTreatments();

        // What does it mean to be fully consistent?
        // All same drug names? We have to also look at dosage?
        // Do we care if they are taking medications outside the treatments for a diagnosis?
        // Can they be taking more than one?
        return false;
    }

    @Action
    public void then() {
        messageTags.add(MESSAGE_TAG);
    }
}
