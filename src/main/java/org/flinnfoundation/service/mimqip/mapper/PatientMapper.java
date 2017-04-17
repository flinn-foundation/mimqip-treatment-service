package org.flinnfoundation.service.mimqip.mapper;


import io.swagger.client.model.PatientDto;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.flinnfoundation.model.Patient;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Component
public class PatientMapper {

    private BoundMapperFacade<Patient, PatientDto> boundMapper;

    protected PatientMapper() {

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.getConverterFactory().registerConverter(new LocalDateTimeConverter());
        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(LocalDate.class));
        mapperFactory.classMap(Patient.class, PatientDto.class)
                .byDefault()
                .register();


        boundMapper = mapperFactory.getMapperFacade(Patient.class, PatientDto.class);
    }

    public PatientDto convertModelToApiDto(Patient entity) {
        return boundMapper.map(entity);
    }

    public Patient convertApiDtoToModel(PatientDto api) {
        return boundMapper.mapReverse(api);
    }

    public List<PatientDto> convertModelToApiDto(Iterable<Patient> patients) {
        return StreamSupport.stream(patients.spliterator(), false)
                .map(this::convertModelToApiDto)
                .collect(Collectors.toList());
    }
}
