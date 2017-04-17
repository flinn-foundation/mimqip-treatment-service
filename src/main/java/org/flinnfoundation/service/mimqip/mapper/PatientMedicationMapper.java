package org.flinnfoundation.service.mimqip.mapper;

import io.swagger.client.model.PatientMedicationDto;
import org.flinnfoundation.model.PatientMedication;
import org.springframework.stereotype.Component;


@Component
public class PatientMedicationMapper extends OrikaMapper<PatientMedication, PatientMedicationDto> {

    protected PatientMedicationMapper() {
        super(PatientMedication.class, PatientMedicationDto.class);
    }
}
