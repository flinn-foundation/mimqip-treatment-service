package org.flinnfoundation.rulerunner;

import org.flinnfoundation.model.Patient;
import org.flinnfoundation.model.evaluation.Evaluation;
import org.flinnfoundation.rules.AbstractBaseRule;
import org.flinnfoundation.rules.generalmessage.GeneralMessageRule;
import org.flinnfoundation.rules.generalmessage.R607a;
import org.flinnfoundation.rules.generalmessage.R607b;
import org.flinnfoundation.service.EvaluationService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GeneralMessageRuleRunner extends AbstractBaseRuleRunner {

    //TODO: having this be static scares me a bit maybe make the evaluate method synchronized
    private static List<AbstractBaseRule> rules = Arrays.asList(new R607a(), new R607b());

    private EvaluationService evaluationService;

    public GeneralMessageRuleRunner(EvaluationService evaluationService) {
        super(rules);
        this.evaluationService = evaluationService;
    }

    @Override
    public List<String> evaluate(Patient patient) {

        List<Evaluation> evaluations = evaluationService.getEvaluations(patient);

        List<String> messageTags = new ArrayList<>();
        for (AbstractBaseRule rule : rules) {
            ((GeneralMessageRule) rule).setPatient(patient);
            ((GeneralMessageRule) rule).setEvaluations(evaluations);

            rule.setMessageTags(messageTags);
        }

        rulesEngine.fireRules();

        return messageTags;
    }
}
