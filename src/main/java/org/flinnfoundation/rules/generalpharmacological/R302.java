package org.flinnfoundation.rules.generalpharmacological;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.flinnfoundation.model.enums.TreatmentGroupType;

@Rule(name = R302.RULE, description = "If 2 or more FGAs are prescribed at the same time")
public class R302 extends PharmacologicalRule {

    static final String RULE = "R302";
    static final String MESSAGE_TAG = "M301";

    @Condition
    public boolean when() {
        return treatmentStatistics.getCountForTreatmentGroupType(TreatmentGroupType.FGA) > 1;
    }

    @Action
    public void then() {
        messageTags.add(MESSAGE_TAG);
    }
}
