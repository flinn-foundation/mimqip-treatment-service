package org.flinnfoundation.rules;

import lombok.Data;
import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.flinnfoundation.model.Patient;

import java.time.LocalDate;

@Data
@Rule(name = R607a.RULE)
public class R607a {

    static final String RULE = "R607a";
    static final String MESSAGE_TAG = "M607a";

    private Patient patient;

    @Condition
    public boolean when() {

        LocalDate threeDaysAgo = LocalDate.now().minusDays(3);

        return patient.getLastEvaluationDate().isAfter(threeDaysAgo);
    }

    @Action
    public void then() {
        patient.addMessageTag(MESSAGE_TAG);
    }
}
