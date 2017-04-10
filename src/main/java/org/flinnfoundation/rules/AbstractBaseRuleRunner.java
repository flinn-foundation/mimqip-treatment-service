package org.flinnfoundation.rules;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.flinnfoundation.model.Patient;

import java.util.List;

public abstract class AbstractBaseRuleRunner {

    protected RulesEngine rulesEngine;

    public AbstractBaseRuleRunner(List<AbstractBaseRule> rules) {
        rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();

        for (AbstractBaseRule rule : rules) {
            rulesEngine.registerRule(rule);
        }
    }

    protected abstract List<String> runRules(Patient patient);
}
