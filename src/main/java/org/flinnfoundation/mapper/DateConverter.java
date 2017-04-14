package org.flinnfoundation.mapper;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class DateConverter extends BidirectionalConverter<Date, OffsetDateTime> {

    @Override
    public OffsetDateTime convertTo(Date source, Type<OffsetDateTime> destinationType, MappingContext mappingContext) {
        return OffsetDateTime.ofInstant(source.toInstant(), ZoneOffset.UTC);
    }

    @Override
    public Date convertFrom(OffsetDateTime source, Type<Date> destinationType, MappingContext mappingContext) {
        return Date.from(source.toInstant());
    }

}
