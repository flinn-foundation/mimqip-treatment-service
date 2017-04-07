package org.flinnfoundation.service;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.flinnfoundation.model.Message;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.respository.MessageRepository;
import org.flinnfoundation.rules.R607a;
import org.flinnfoundation.rules.R607b;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralMessageRecommendationService {

    private RulesEngine rulesEngine;
    private MessageRepository messageRepository;

    private R607a r607a = new R607a();
    private R607b r607b = new R607b();

    @Autowired
    public GeneralMessageRecommendationService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;

        rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();

        rulesEngine.registerRule(r607a);
        rulesEngine.registerRule(r607b);
    }

    public Iterable<Message> getGeneralMessage(Patient patient) {

        r607a.setPatient(patient);
        r607b.setPatient(patient);

        rulesEngine.fireRules();

        return messageRepository.findByMessageTag(patient.getMessageTags());
    }
}
