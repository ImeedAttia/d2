package com.droovo.tn.rideservice.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import java.time.*;

@Mapper(componentModel = "spring")
public interface TimerMapper {

    @Named("localDateTimeToInstant")
    default Instant localDateTimeToInstant(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.atZone(ZoneId.systemDefault()).toInstant() : null;
    }

    @Named("instantToLocalDateTime")
    default LocalDateTime instantToLocalDateTime(Instant instant) {
        return instant != null ? instant.atZone(ZoneId.systemDefault()).toLocalDateTime() : null;
    }
}

