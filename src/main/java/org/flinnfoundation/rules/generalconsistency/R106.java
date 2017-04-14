package org.flinnfoundation.rules.generalconsistency;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = R106.RULE)
public class R106 extends ConsistencyRule {

    static final String RULE = "R106";
    static final String MESSAGE_TAG = "M106";

    @Condition
    public boolean when() {

        /*
        IF there is a match between the patient drug set and the guideline drug set with one or more
        additional drugs in the patient drug set: THEN
         */

        return false;
    }

    @Action
    public void then() {
        messageTags.add(MESSAGE_TAG);
    }
}
