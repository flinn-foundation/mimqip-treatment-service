package org.flinnfoundation.rules.generalconsistency;

import lombok.Data;
import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Data
@Rule(name = R105.RULE)
public class R105 extends ConsistencyRule {

    static final String RULE = "R105";
    static final String MESSAGE_TAG = "M105";

    @Condition
    public boolean when() {
        /*
        IF any drugs in the patient drug set are first introduced in a stage higher than the patient&#39;s
        current stage of treatment: THEN
         */
        return false;
    }

    @Action
    public void then() {
        messageTags.add(MESSAGE_TAG);
    }
}
