package org.flinnfoundation.mapper;


import io.swagger.client.model.EvaluationDto;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.flinnfoundation.model.evaluation.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Component
public class EvaluationMapper {

    private BoundMapperFacade<Evaluation, EvaluationDto> boundMapper;

    @Autowired
    protected EvaluationMapper() {

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.getConverterFactory().registerConverter(new DateConverter());
        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(LocalDateTime.class));
        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(LocalDate.class));
        mapperFactory.classMap(Evaluation.class, EvaluationDto.class)
                .field("patient.id", "patientId")
                .byDefault()
                .register();


        boundMapper = mapperFactory.getMapperFacade(Evaluation.class, EvaluationDto.class);
    }

    public EvaluationDto convertModelToApiDto(Evaluation entity) {
        return boundMapper.map(entity);
    }

    public Evaluation convertApiDtoToModel(EvaluationDto api) {
        return boundMapper.mapReverse(api);
    }

    public List<EvaluationDto> convertModelToApiDto(Iterable<Evaluation> evaluations) {
        return StreamSupport.stream(evaluations.spliterator(), false)
                .map(this::convertModelToApiDto)
                .collect(Collectors.toList());
    }

    public List<Evaluation> convertApiDtoToModel(Iterable<EvaluationDto> evaluationDtos) {
        return StreamSupport.stream(evaluationDtos.spliterator(), false)
                .map(this::convertApiDtoToModel)
                .collect(Collectors.toList());
    }
}
