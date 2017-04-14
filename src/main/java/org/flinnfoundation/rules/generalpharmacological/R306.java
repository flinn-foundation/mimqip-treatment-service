package org.flinnfoundation.rules.generalpharmacological;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.flinnfoundation.model.enums.TreatmentGroupType;

@Rule(name = R306.RULE, description = "IF 2 or more TCAs are prescribed at the same time")
public class R306 extends PharmacologicalRule {

    static final String RULE = "R306";
    static final String MESSAGE_TAG = "M302";

    @Condition
    public boolean when() {
        return treatmentStatistics.getCountForTreatmentGroupType(TreatmentGroupType.TCA) > 1;
    }

    @Action
    public void then() {
        messageTags.add(MESSAGE_TAG);
    }
}
