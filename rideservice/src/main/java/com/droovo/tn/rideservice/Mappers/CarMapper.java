package com.droovo.tn.rideservice.Mappers;

import com.droovo.tn.rideservice.DTO.CarDto;
import com.droovo.tn.rideservice.Entities.Car;
import com.droovo.tn.rideservice.Entities.Enum.CarStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {SeatMapper.class, CarStatus.class})
public interface CarMapper {

    // Mapping Car entity to CarDto
    CarDto toDto(Car car);

    // Mapping CarDto to Car entity
    Car toEntity(CarDto carDto);
}