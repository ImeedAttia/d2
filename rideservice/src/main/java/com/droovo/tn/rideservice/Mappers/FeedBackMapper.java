package com.droovo.tn.rideservice.Mappers;

import com.droovo.tn.rideservice.DTO.FeedbackDto;
import com.droovo.tn.rideservice.Entities.FeedBack;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedBackMapper {
    //Map from DTO to Entity
    //FeedBack to FeedBackDTO
    FeedbackDto toDto(FeedBack feedBack);
    //Map from Entity to DTO
    FeedBack toEntity(FeedbackDto feedbackDto);

}
