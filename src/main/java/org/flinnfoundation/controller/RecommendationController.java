package org.flinnfoundation.controller;

import org.flinnfoundation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationController {

    private RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/treatments")
    public String getTreatments(PatientDataDto patientData) {
        recommendationService.getTreatments();
        return "";
    }

    @GetMapping("/diagnoses")
    public String getDiagnoses(PatientDataDto patientData) {
        recommendationService.getDiagnoses();
        return "";
    }
}
