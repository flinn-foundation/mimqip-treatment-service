package org.flinnfoundation.rules.generalpharmacological;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.flinnfoundation.model.enums.TreatmentGroupType;

@Rule(name = R304.RULE, description = "If 2 or more SNRIs are prescribed at the same time")
public class R304 extends PharmacologicalRule {

    static final String RULE = "R304";
    static final String MESSAGE_TAG = "M302";

    @Condition
    public boolean when() {
        return treatmentStatistics.getCountForTreatmentGroupType(TreatmentGroupType.SNRI) > 1;
    }

    @Action
    public void then() {
        messageTags.add(MESSAGE_TAG);
    }
}
