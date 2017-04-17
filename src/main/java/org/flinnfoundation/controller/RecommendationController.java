package org.flinnfoundation.controller;

import io.swagger.api.MessageApi;
import io.swagger.model.MessageDto;
import org.flinnfoundation.mapper.MessageMapper;
import org.flinnfoundation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationController implements MessageApi {

    private RecommendationService recommendationService;
    private MessageMapper messageMapper;

    @Autowired
    public RecommendationController(RecommendationService recommendationService, MessageMapper messageMapper) {
        this.recommendationService = recommendationService;
        this.messageMapper = messageMapper;
    }

    @Override
    public ResponseEntity<List<MessageDto>> getMessages(@RequestParam Long patientId) {
        return ResponseEntity.ok(messageMapper.convertModelToApiDto(recommendationService.getMessagesForPatient(patientId)));
    }
}
