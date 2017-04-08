package org.flinnfoundation.rules.generalpharmacological;

import lombok.Data;
import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.flinnfoundation.model.enums.TreatmentGroupType;

@Data
@Rule(name = R307.RULE, description = "If a MAOI and a SSRI or SSRI are prescribed at the same time")
public class R307 extends PharmacologicalRule {

    static final String RULE = "R307";
    static final String MESSAGE_TAG = "M303";

    @Condition
    public boolean when() {
        return treatmentStatistics.getCountForTreatmentGroupType(TreatmentGroupType.MAOI) > 0 &&
                (treatmentStatistics.getCountForTreatmentGroupType(TreatmentGroupType.SSRI) > 0
                        || treatmentStatistics.getCountForTreatmentGroupType(TreatmentGroupType.SNRI) > 0);
    }

    @Action
    public void then() {
        messageTags.add(MESSAGE_TAG);
    }
}
