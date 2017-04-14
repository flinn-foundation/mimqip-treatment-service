package org.flinnfoundation.mapper;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class OrikaMapper<T, K> {

    private BoundMapperFacade<T, K> boundMapper;

    protected OrikaMapper(Class<T> clazzT, Class<K> clazzK) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.getConverterFactory().registerConverter(new DateConverter());
        mapperFactory.getConverterFactory().registerConverter(new LocalDateTimeConverter());
        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(LocalDate.class));
        boundMapper = mapperFactory.getMapperFacade(clazzT, clazzK);
    }

    public K convertModelToApiDto(T entity) {
        return boundMapper.map(entity);
    }

    public T convertApiDtoToModel(K api) {
        return boundMapper.mapReverse(api);
    }

    public List<K> convertModelToApiDto(Iterable<T> models) {
        return StreamSupport.stream(models.spliterator(), false)
                .map(this::convertModelToApiDto)
                .collect(Collectors.toList());
    }

    public List<T> convertApiDtoToModel(Iterable<K> dtos) {
        return StreamSupport.stream(dtos.spliterator(), false)
                .map(this::convertApiDtoToModel)
                .collect(Collectors.toList());
    }

}
