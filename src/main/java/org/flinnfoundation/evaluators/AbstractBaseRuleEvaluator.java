package org.flinnfoundation.evaluators;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.rules.AbstractBaseRule;

import java.util.List;

abstract public class AbstractBaseRuleEvaluator {

    protected RulesEngine rulesEngine;

    public AbstractBaseRuleEvaluator(List<AbstractBaseRule> rules) {
        rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();

        for (AbstractBaseRule rule : rules) {
            rulesEngine.registerRule(rule);
        }
    }

    abstract List<String> evaluate(Patient patient);
}
