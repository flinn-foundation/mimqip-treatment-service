package org.flinnfoundation.rules.generalconsistency;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = R104.RULE)
public class R104 extends ConsistencyRule {

    static final String RULE = "R102";
    static final String MESSAGE_TAG = "M102";

    @Condition
    public boolean when() {
        /*IF there is an exact match between the patient drug set and the guideline drug set for any stage
        of treatment above the patient&#39;s current stage: THEN
        */

//        Diagnosis diagnosis = patient.getDiagnosis();
//        List<Treatment> guidelineTreatments = diagnosis.getTreatments();
//
//        List<Treatment> patientTreatments = patient.getTreatments();

        return false;
    }

    @Action
    public void then() {
        messageTags.add(MESSAGE_TAG);
    }
}
