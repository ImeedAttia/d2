package com.droovo.tn.rideservice.Mappers;

import com.droovo.tn.rideservice.DTO.RideDto;
import com.droovo.tn.rideservice.Entities.Rides;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {CarMapper.class, TimerMapper.class, SeatMapper.class})
public interface RidesMapper {
    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "localDateTimeToInstant")
    @Mapping(source = "updatedAt", target = "updatedAt", qualifiedByName = "localDateTimeToInstant")
    RideDto toDto(Rides rides);

    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "instantToLocalDateTime")
    @Mapping(source = "updatedAt", target = "updatedAt", qualifiedByName = "instantToLocalDateTime")
    Rides toEntity(RideDto rideDto);
}
