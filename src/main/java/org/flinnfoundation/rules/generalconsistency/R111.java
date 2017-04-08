package org.flinnfoundation.rules.generalconsistency;

import lombok.Data;
import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Data
@Rule(name = R111.RULE)
public class R111 extends ConsistencyRule{

    static final String RULE = "R111";
    static final String MESSAGE_TAG = "M111";

    @Condition
    public boolean when() {

        /*
        For all patients who have a diagnosis of BPD(M) AND are being prescribed lamotrigine;
        IF the patient does not have a prior diagnosis of BPD(D): THEN
         */


       return false;
    }

    @Action
    public void then() {
        messageTags.add(MESSAGE_TAG);
    }
}
