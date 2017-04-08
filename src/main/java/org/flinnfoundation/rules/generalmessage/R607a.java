package org.flinnfoundation.rules.generalmessage;

import lombok.Data;
import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import java.time.LocalDate;

@Data
@Rule(name = R607a.RULE)
public class R607a extends GeneralMessageRule {

    static final String RULE = "R607a";
    static final String MESSAGE_TAG = "M607a";

    @Condition
    public boolean when() {

        LocalDate threeDaysAgo = LocalDate.now().minusDays(3);

        return patient.getLastEvaluationDate().isAfter(threeDaysAgo);
    }

    @Action
    public void then() {
        messageTags.add(MESSAGE_TAG);
    }
}
