package org.flinnfoundation.rules;

import lombok.Data;
import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.flinnfoundation.fact.Patient;

import java.time.LocalDate;
import java.util.List;

@Data
@Rule(name = M607a.RULE)
public class M607a {

    static final String RULE = "M607a";

    private Patient patient;
    private List<String> activeRules;

    @Condition
    public boolean when() {

        LocalDate threeDaysAgo = LocalDate.now().minusDays(3);

        return patient.getLastEvaluationDate().isAfter(threeDaysAgo);
    }

    @Action
    public void then() {
        activeRules.add(RULE);
    }
}
