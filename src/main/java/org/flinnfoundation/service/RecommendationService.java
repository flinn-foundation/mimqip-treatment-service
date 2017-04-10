package org.flinnfoundation.service;

import org.flinnfoundation.model.Message;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.respository.MessageRepository;
import org.flinnfoundation.rules.generalconsistency.ConsistencyRuleRunner;
import org.flinnfoundation.rules.generalmessage.GeneralMessageRuleRunner;
import org.flinnfoundation.rules.generalpharmacological.PharmacologicalRuleRunner;
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

        List<String> generalMessageTags = generalMessageRuleEvaluator.runRules(patient);
        return messageRepository.findByMessageTag(generalMessageTags);
    }


}
