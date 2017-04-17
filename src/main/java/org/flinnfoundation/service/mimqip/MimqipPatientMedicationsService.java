package org.flinnfoundation.service.mimqip;

import io.swagger.client.model.PatientMedicationDto;
import lombok.extern.slf4j.Slf4j;
import org.flinnfoundation.api.mimqip.MimqipPatientMedicationApi;
import org.flinnfoundation.service.mimqip.exception.MimqipPatientMedicationException;
import org.flinnfoundation.service.mimqip.mapper.PatientMedicationMapper;
import org.flinnfoundation.model.PatientMedication;
import org.flinnfoundation.service.PatientMedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class MimqipPatientMedicationsService implements PatientMedicationService {

    private MimqipPatientMedicationApi mimqipPatientMedicationApi;
    private PatientMedicationMapper patientMedicationMapper;

    @Autowired
    public MimqipPatientMedicationsService(MimqipPatientMedicationApi mimqipPatientMedicationApi, PatientMedicationMapper patientMedicationMapper) {
        this.mimqipPatientMedicationApi = mimqipPatientMedicationApi;
        this.patientMedicationMapper = patientMedicationMapper;
    }

    @Override
    public List<PatientMedication> getMedications(long patientId) {
        Response<List<PatientMedicationDto>> patientMedicationsResponse;
        try {
            patientMedicationsResponse = mimqipPatientMedicationApi.getPatientMedications(patientId).execute();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new MimqipPatientMedicationException(e);
        }

        return patientMedicationMapper.convertApiDtoToModel(patientMedicationsResponse.body());
    }

}
