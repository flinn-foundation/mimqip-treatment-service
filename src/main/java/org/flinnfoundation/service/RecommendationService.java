package org.flinnfoundation.service;

import org.flinnfoundation.model.Message;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.respository.MessageRepository;
import org.flinnfoundation.rulerunner.ConsistencyRuleRunner;
import org.flinnfoundation.rulerunner.GeneralMessageRuleRunner;
import org.flinnfoundation.rulerunner.PharmacologicalRuleRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private PatientService patientService;

    private MessageRepository messageRepository;

    private GeneralMessageRuleRunner generalMessageRuleEvaluator;
    private ConsistencyRuleRunner consistencyRuleEvaluator;
    private PharmacologicalRuleRunner pharmacologicalRuleEvaluator;

    @Autowired
    public RecommendationService(PatientService patientService, MessageRepository messageRepository, GeneralMessageRuleRunner generalMessageRuleEvaluator) {
        this.patientService = patientService;
        this.messageRepository = messageRepository;
        this.generalMessageRuleEvaluator = generalMessageRuleEvaluator;
    }

    public List<Message> getMessagesForPatient(long patientId) {
        Patient patient = patientService.getPatient(patientId);

        List<String> generalMessageTags = generalMessageRuleEvaluator.evaluate(patient);
        return messageRepository.findByMessageTag(generalMessageTags);
    }


}
