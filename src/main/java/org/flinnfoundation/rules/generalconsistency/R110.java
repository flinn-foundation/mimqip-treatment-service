package org.flinnfoundation.rules.generalconsistency;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = R110.RULE)
public class R110 extends ConsistencyRule{

    static final String RULE = "R110";
    static final String MESSAGE_TAG = "M110";

    @Condition
    public boolean when() {

        /*
        For all patients who have a diagnosis of BPD(M) AND are being prescribed lamotrigine;
        IF the patient has a prior diagnosis of BPD(D): THEN
         */

        return false;
    }

    @Action
    public void then() {
        messageTags.add(MESSAGE_TAG);
    }
}
