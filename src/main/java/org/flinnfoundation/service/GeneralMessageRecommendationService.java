package org.flinnfoundation.service;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.flinnfoundation.fact.Patient;
import org.flinnfoundation.rules.M607a;
import org.springframework.stereotype.Service;

@Service
public class GeneralMessageRecommendationService {

    private RulesEngine rulesEngine;


    public GeneralMessageRecommendationService() {
        rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();

    }

    public void getGeneralMessage(Patient patient) {

        M607a m607a = new M607a();
        m607a.setPatient(patient);

        rulesEngine.registerRule(m607a);

        rulesEngine.fireRules();
    }
}
