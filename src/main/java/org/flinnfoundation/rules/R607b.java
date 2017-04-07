package org.flinnfoundation.rules;

import lombok.Data;
import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.flinnfoundation.model.Patient;

import java.time.LocalDate;

@Data
@Rule(name = R607b.RULE)
public class R607b {

    static final String RULE = "R607b";
    static final String MESSAGE_TAG = "M607b";

    private Patient patient;

    @Condition
    public boolean when() {

        LocalDate threeDaysAgo = LocalDate.now().minusDays(3);
        LocalDate lastEvaluationDate = patient.getLastEvaluationDate();

        return lastEvaluationDate.isBefore(threeDaysAgo) || lastEvaluationDate.isEqual(threeDaysAgo);
    }

    @Action
    public void then() {
        patient.addMessageTag(MESSAGE_TAG);
    }
}
