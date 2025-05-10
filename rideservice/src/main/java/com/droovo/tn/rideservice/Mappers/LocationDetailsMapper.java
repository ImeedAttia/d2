package com.droovo.tn.rideservice.Mappers;

import com.droovo.tn.rideservice.DTO.LocationDetailsDto;
import com.droovo.tn.rideservice.Entities.LocationDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LocationDetailsMapper {
    LocationDetailsMapper INSTANCE = Mappers.getMapper(LocationDetailsMapper.class);

    //Map LocationDetails to LocationDetailsDto
    LocationDetailsDto toDto(LocationDetails locationDetails);

    //Map LocationDetailsDto toEntity(LocationDetailsDto locationDetailsDto);
    LocationDetails toEntity(LocationDetailsDto locationDetailsDto);

}
