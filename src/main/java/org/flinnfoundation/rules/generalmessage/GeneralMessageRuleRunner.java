package org.flinnfoundation.rules.generalmessage;

import org.flinnfoundation.model.Patient;
import org.flinnfoundation.model.evaluation.Evaluation;
import org.flinnfoundation.rules.AbstractBaseRule;
import org.flinnfoundation.rules.AbstractBaseRuleRunner;
import org.flinnfoundation.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GeneralMessageRuleRunner extends AbstractBaseRuleRunner {

    //TODO: having this be static scares me a bit maybe make the runRules method synchronized
    private static List<AbstractBaseRule> rules = Arrays.asList(new R607a(), new R607b());

    private EvaluationService evaluationService;

    @Autowired
    public GeneralMessageRuleRunner(EvaluationService evaluationService) {
        super(rules);
        this.evaluationService = evaluationService;
    }

    @Override
    public List<String> runRules(Patient patient) {

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
