package org.flinnfoundation.service.mimqip;

import io.swagger.client.model.PatientDto;
import lombok.extern.slf4j.Slf4j;
import org.flinnfoundation.api.mimqip.MimqipPatientApi;
import org.flinnfoundation.service.EvaluationService;
import org.flinnfoundation.service.mimqip.exception.MimqipPatientException;
import org.flinnfoundation.service.DiagnosisService;
import org.flinnfoundation.service.mimqip.mapper.PatientMapper;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;

@Slf4j
@Service
public class MimqipPatientService implements PatientService {

    private MimqipPatientApi mimqipPatientApi;
    private PatientMapper patientMapper;

    private DiagnosisService diagnosisService;
    private EvaluationService evaluationService;

    @Autowired
    public MimqipPatientService(MimqipPatientApi mimqipPatientApi, PatientMapper patientMapper, DiagnosisService diagnosisService, EvaluationService evaluationService) {
        this.mimqipPatientApi = mimqipPatientApi;
        this.patientMapper = patientMapper;
        this.diagnosisService = diagnosisService;
        this.evaluationService = evaluationService;
    }

    @Override
    public Patient getPatient(long patientId) {
        Patient patient = getPatientData(patientId);
        patient.setDiagnosis(diagnosisService.getLatestDiagnosis(patientId));
        patient.setEvaluations(evaluationService.getEvaluations(patientId));


        return patient;
    }

    private Patient getPatientData(long patientId) {

        Response<PatientDto> patientDtoResponse;
        try {
            patientDtoResponse = mimqipPatientApi.getPatient(patientId).execute();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new MimqipPatientException(e);
        }

        if(!patientDtoResponse.isSuccessful()) {
            throw new MimqipPatientException("Could not find patient with ID:" + patientId);
        }

        PatientDto patientDto = patientDtoResponse.body();
        return patientMapper.convertApiDtoToModel(patientDto);
    }

//
}
