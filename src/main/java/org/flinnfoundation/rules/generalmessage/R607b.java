package org.flinnfoundation.rules.generalmessage;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = R607b.RULE, description = "FOR all diagnoses IF the patient's diagnosis related scale and/or global rating scales were completed 3 or more days days ago")
public class R607b extends GeneralMessageRule {

    static final String RULE = "R607b";
    static final String MESSAGE_TAG = "M607b";

    @Condition
    public boolean when() {

        return !hasRecentRelatedEvaluation();

    }

    @Action
    public void then() {
        messageTags.add(MESSAGE_TAG);
    }
}
