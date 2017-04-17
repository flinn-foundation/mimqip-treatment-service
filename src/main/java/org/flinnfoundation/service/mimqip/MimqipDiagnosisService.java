package org.flinnfoundation.service.mimqip;

import io.swagger.client.model.DiagnosisDto;
import lombok.extern.slf4j.Slf4j;
import org.flinnfoundation.api.mimqip.MimqipDiagnosisApi;
import org.flinnfoundation.model.Diagnosis;
import org.flinnfoundation.service.DiagnosisService;
import org.flinnfoundation.service.mimqip.exception.MimqipDiagnosisException;
import org.flinnfoundation.service.mimqip.mapper.DiagnosisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class MimqipDiagnosisService implements DiagnosisService {

    private MimqipDiagnosisApi mimqipDiagnosisApi;
    private DiagnosisMapper diagnosisMapper;

    @Autowired
    public MimqipDiagnosisService(MimqipDiagnosisApi mimqipPatientApi, DiagnosisMapper diagnosisMapper) {
        this.mimqipDiagnosisApi = mimqipPatientApi;
        this.diagnosisMapper = diagnosisMapper;
    }

    @Override
    public Diagnosis getLatestDiagnosis(long patientId) {
        Response<DiagnosisDto> diagnosisResponse;
        try {
            diagnosisResponse = mimqipDiagnosisApi.getLatestDiagnosis(patientId).execute();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new MimqipDiagnosisException(e);
        }

        return diagnosisMapper.convertApiDtoToModel(diagnosisResponse.body());
    }

    @Override
    public List<Diagnosis> getDiagnoses(long patientId) {
        Response<List<DiagnosisDto>> diagnosisResponses;
        try {
            diagnosisResponses = mimqipDiagnosisApi.getDiagnoses(patientId).execute();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new MimqipDiagnosisException(e);
        }

        return diagnosisMapper.convertApiDtoToModel(diagnosisResponses.body());
    }
}
