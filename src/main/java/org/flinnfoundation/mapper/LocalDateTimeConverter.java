package org.flinnfoundation.mapper;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class LocalDateTimeConverter extends BidirectionalConverter<LocalDateTime, OffsetDateTime> {

    @Override
    public OffsetDateTime convertTo(LocalDateTime source, Type<OffsetDateTime> destinationType, MappingContext mappingContext) {
        return OffsetDateTime.of(source, ZoneOffset.UTC);
    }

    @Override
    public LocalDateTime convertFrom(OffsetDateTime source, Type<LocalDateTime> destinationType, MappingContext mappingContext) {
        return source.toLocalDateTime();
    }

}
