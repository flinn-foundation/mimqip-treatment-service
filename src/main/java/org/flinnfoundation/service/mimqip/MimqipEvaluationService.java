package org.flinnfoundation.service.mimqip;

import io.swagger.client.model.EvaluationDto;
import lombok.extern.slf4j.Slf4j;
import org.flinnfoundation.api.mimqip.MimqipEvaluationApi;
import org.flinnfoundation.model.evaluation.Evaluation;
import org.flinnfoundation.model.evaluation.EvaluationType;
import org.flinnfoundation.service.EvaluationService;
import org.flinnfoundation.service.mimqip.exception.MimqipEvaluationException;
import org.flinnfoundation.service.mimqip.mapper.EvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class MimqipEvaluationService implements EvaluationService {

    private MimqipEvaluationApi mimqipEvaluationApi;
    private EvaluationMapper evaluationMapper;

    @Autowired
    public MimqipEvaluationService(MimqipEvaluationApi mimqipEvaluationApi, EvaluationMapper evaluationMapper) {
        this.mimqipEvaluationApi = mimqipEvaluationApi;
        this.evaluationMapper = evaluationMapper;
    }

    @Override
    public List<Evaluation> getEvaluations(long patientId) {
        return getEvaluations(patientId, null);
    }

    @Override
    public List<Evaluation> getEvaluations(long patientId, EvaluationType evaluationType) {
        Response<List<EvaluationDto>> evaluationResponse;
        try {
            evaluationResponse = mimqipEvaluationApi.getEvaluations(patientId, evaluationType).execute();
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new MimqipEvaluationException(e.getMessage(), e);
        }

        return evaluationMapper.convertApiDtoToModel(evaluationResponse.body());
    }

}
