package org.flinnfoundation.service;

import io.swagger.client.model.EvaluationDto;
import lombok.extern.slf4j.Slf4j;
import org.flinnfoundation.api.mimqip.MimqipEvaluationApi;
import org.flinnfoundation.exception.MimqipEvaluationException;
import org.flinnfoundation.mapper.EvaluationMapper;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.model.evaluation.Evaluation;
import org.flinnfoundation.model.evaluation.EvaluationType;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class MimqipEvaluationService implements EvaluationService {

    private MimqipEvaluationApi mimqipEvaluationApi;
    private EvaluationMapper evaluationMapper;

    public MimqipEvaluationService(MimqipEvaluationApi mimqipEvaluationApi, EvaluationMapper evaluationMapper) {
        this.mimqipEvaluationApi = mimqipEvaluationApi;
        this.evaluationMapper = evaluationMapper;
    }

    @Override
    public List<Evaluation> getEvaluations(Patient patient) {
        return getEvaluations(patient, null);
    }

    @Override
    public List<Evaluation> getEvaluations(Patient patient, EvaluationType evaluationType) {
        Response<List<EvaluationDto>> evaluationResponse;
        try {
            evaluationResponse = mimqipEvaluationApi.getEvaluations(patient.getId(), evaluationType).execute();
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new MimqipEvaluationException(e.getMessage(), e);
        }

        List<EvaluationDto> evaluationDtos = evaluationResponse.body();
        return evaluationMapper.convertApiDtoToModel(evaluationDtos);
    }

}
