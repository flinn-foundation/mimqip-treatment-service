package org.flinnfoundation.mapper;

import org.flinnfoundation.api.mimqip.PatientMedicationDto;
import org.flinnfoundation.model.PatientMedication;
import org.springframework.stereotype.Component;


@Component
public class PatientMedicationMapper extends OrikaMapper<PatientMedication, PatientMedicationDto> {

    protected PatientMedicationMapper() {
        super(PatientMedication.class, PatientMedicationDto.class);
    }
}
