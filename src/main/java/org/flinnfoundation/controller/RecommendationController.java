package org.flinnfoundation.controller;

import org.flinnfoundation.evaluators.GeneralMessageRuleEvaluator;
import org.flinnfoundation.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class RecommendationController {

    private GeneralMessageRuleEvaluator generalMessageRecommendationService;

    @Autowired
    public RecommendationController(GeneralMessageRuleEvaluator generalMessageRecommendationService) {
        this.generalMessageRecommendationService = generalMessageRecommendationService;
    }

    @GetMapping("/messages")
    public List<String> getMessages(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate lastEvaluationDate) {
        Patient patient = new Patient();
        patient.setLastEvaluationDate(lastEvaluationDate);

        return generalMessageRecommendationService.evaluate(patient);
    }
}
