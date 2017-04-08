package org.flinnfoundation.evaluators;

import org.flinnfoundation.model.Patient;
import org.flinnfoundation.rules.AbstractBaseRule;
import org.flinnfoundation.rules.generalmessage.GeneralMessageRule;
import org.flinnfoundation.rules.generalmessage.R607a;
import org.flinnfoundation.rules.generalmessage.R607b;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GeneralMessageRuleEvaluator extends AbstractBaseRuleEvaluator {

    //TODO: having this be static scares me a bit maybe make the evaluate method synchronized
    private static List<AbstractBaseRule> rules = Arrays.asList(new R607a(), new R607b());

    public GeneralMessageRuleEvaluator() {
        super(rules);
    }

    @Override
    public List<String> evaluate(Patient patient) {

        List<String> messageTags = new ArrayList<>();
        for (AbstractBaseRule rule : rules) {
            ((GeneralMessageRule) rule).setPatient(patient);
            rule.setMessageTags(messageTags);
        }

        rulesEngine.fireRules();

        return messageTags;
    }

}
