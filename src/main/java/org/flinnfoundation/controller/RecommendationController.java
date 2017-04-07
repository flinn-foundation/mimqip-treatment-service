package org.flinnfoundation.controller;

import org.flinnfoundation.model.Message;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.service.GeneralMessageRecommendationService;
import org.flinnfoundation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class RecommendationController {

    private RecommendationService recommendationService;
    private GeneralMessageRecommendationService generalMessageRecommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService, GeneralMessageRecommendationService generalMessageRecommendationService) {
        this.recommendationService = recommendationService;
        this.generalMessageRecommendationService = generalMessageRecommendationService;
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

    @GetMapping("/messages")
    public Iterable<Message> getMessages(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate lastEvaluationDate) {
        Patient patient = new Patient();
        patient.setLastEvaluationDate(lastEvaluationDate);

        return generalMessageRecommendationService.getGeneralMessage(patient);
    }
}
