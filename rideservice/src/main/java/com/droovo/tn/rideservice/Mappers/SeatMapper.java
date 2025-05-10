package com.droovo.tn.rideservice.Mappers;

import com.droovo.tn.rideservice.DTO.SeatDto;
import com.droovo.tn.rideservice.Entities.Seat;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = { TimerMapper.class, RidesMapper.class }
)
public interface SeatMapper {

    SeatDto toDto(Seat seat);
    Seat toEntity(SeatDto seatDto);
}

