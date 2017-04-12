package org.flinnfoundation.service;

import io.swagger.client.model.PatientDto;
import lombok.extern.slf4j.Slf4j;
import org.flinnfoundation.api.mimqip.MimqipPatientApi;
import org.flinnfoundation.api.mimqip.PatientMedicationDto;
import org.flinnfoundation.exception.MimqipPatientException;
import org.flinnfoundation.exception.MimqipPatientMedicationException;
import org.flinnfoundation.mapper.PatientMapper;
import org.flinnfoundation.mapper.PatientMedicationMapper;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.model.PatientMedication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class MimqipPatientService implements PatientService {

    private MimqipPatientApi mimqipPatientApi;
    private PatientMapper patientMapper;
    private PatientMedicationMapper patientMedicationMapper;

    @Autowired
    public MimqipPatientService(MimqipPatientApi mimqipPatientApi, PatientMapper patientMapper, PatientMedicationMapper patientMedicationMapper) {
        this.mimqipPatientApi = mimqipPatientApi;
        this.patientMapper = patientMapper;
        this.patientMedicationMapper = patientMedicationMapper;
    }

    @Override
    public Patient getPatient(long patientId) {
        Patient patient = getPatientWithoutMedications(patientId);
//        patient.setPatientMedications(getPatientMedications(patient));

        return patient;
    }

    private Patient getPatientWithoutMedications(long patientId) {

        Response<PatientDto> patientDtoResponse;
        try {
            patientDtoResponse = mimqipPatientApi.getPatient(patientId).execute();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new MimqipPatientException(e);
        }

        PatientDto patientDto = patientDtoResponse.body();
        return patientMapper.convertApiDtoToModel(patientDto);
    }

    private List<PatientMedication> getPatientMedications(Patient patient) {
        Response<List<PatientMedicationDto>> patientMedicationsResponse;
        try {
            patientMedicationsResponse = mimqipPatientApi.getPatientMedications(patient.getId()).execute();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new MimqipPatientMedicationException(e);
        }

        return patientMedicationMapper.convertApiDtoToModel(patientMedicationsResponse.body());
    }
}
