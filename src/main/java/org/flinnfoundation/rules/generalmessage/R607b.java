package org.flinnfoundation.rules.generalmessage;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import java.time.LocalDate;

@Rule(name = R607b.RULE)
public class R607b extends GeneralMessageRule {

    static final String RULE = "R607b";
    static final String MESSAGE_TAG = "M607b";

    @Condition
    public boolean when() {

        LocalDate threeDaysAgo = LocalDate.now().minusDays(3);
        LocalDate lastEvaluationDate = patient.getLastEvaluationDate();

        return lastEvaluationDate.isBefore(threeDaysAgo) || lastEvaluationDate.isEqual(threeDaysAgo);
    }

    @Action
    public void then() {
        messageTags.add(MESSAGE_TAG);
    }
}
