package org.flinnfoundation.rules.generalpharmacological;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.flinnfoundation.model.enums.TreatmentGroupType;

@Rule(name = R303.RULE, description = "If 2 or more SSRIs are prescribed at the same time")
public class R303 extends PharmacologicalRule {

    static final String RULE = "R303";
    static final String MESSAGE_TAG = "M302";

    @Condition
    public boolean when() {
        return treatmentStatistics.getCountForTreatmentGroupType(TreatmentGroupType.SSRI) > 1;
    }

    @Action
    public void then() {
        messageTags.add(MESSAGE_TAG);
    }
}
