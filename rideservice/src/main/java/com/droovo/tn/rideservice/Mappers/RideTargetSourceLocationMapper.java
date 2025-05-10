package com.droovo.tn.rideservice.Mappers;

import com.droovo.tn.rideservice.DTO.GeoPointDto;
import com.droovo.tn.rideservice.DTO.RideTargetSourceLocationDto;
import com.droovo.tn.rideservice.Entities.RideTargetSourceLocation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {
                LocationDetailsMapper.class, GeoPointDto.class},
        imports = {GeoPointDto.class})
public interface RideTargetSourceLocationMapper {

    // Mapping Car entity to RideTargetSourceLocationDto
    RideTargetSourceLocationDto toDto(RideTargetSourceLocation rideTargetSourceLocation);

    // Mapping RideTargetSourceLocationDto to Car entity
    RideTargetSourceLocation toEntity(RideTargetSourceLocationDto rideTargetSourceLocationDto);
}
