package com.droovo.tn.rideservice.Services;

import com.droovo.tn.rideservice.DTO.RideDto;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface IRideService {
    RideDto createRide(RideDto rideDto);
    RideDto getRideById(String uid);
    boolean deleteRide(String uid);
    RideDto updateRide(String uid, Map<Object,Object> fields);
    Iterable<RideDto> getAllRides();
    Page<RideDto> getRidesByPage(int page, int size);
}
