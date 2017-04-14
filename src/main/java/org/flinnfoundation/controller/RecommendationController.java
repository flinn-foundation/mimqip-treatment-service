package org.flinnfoundation.controller;

import org.flinnfoundation.model.Message;
import org.flinnfoundation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationController {

    private RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/messages")
    public List<Message> getMessages(@RequestParam long patientId) {

        return recommendationService.getMessagesForPatient(patientId);
    }
}
