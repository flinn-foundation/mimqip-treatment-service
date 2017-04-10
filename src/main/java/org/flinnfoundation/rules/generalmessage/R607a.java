package org.flinnfoundation.rules.generalmessage;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = R607a.RULE, description = "FOR all diagnoses IF the patient's diagnosis related scale and/or global rating scales were completed less than 3 days ago")
public class R607a extends GeneralMessageRule {

    static final String RULE = "R607a";
    static final String MESSAGE_TAG = "M607a";

    @Condition
    public boolean when() {

        return hasRecentRelatedEvaluation();
    }

    @Action
    public void then() {
        messageTags.add(MESSAGE_TAG);
    }
}
