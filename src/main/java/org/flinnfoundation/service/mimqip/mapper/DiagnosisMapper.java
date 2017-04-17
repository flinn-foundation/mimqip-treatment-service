package org.flinnfoundation.service.mimqip.mapper;

import io.swagger.client.model.DiagnosisDto;
import org.flinnfoundation.model.Diagnosis;
import org.springframework.stereotype.Component;


@Component
public class DiagnosisMapper extends OrikaMapper<Diagnosis, DiagnosisDto> {

    protected DiagnosisMapper() {
        super(Diagnosis.class, DiagnosisDto.class);
    }
}
