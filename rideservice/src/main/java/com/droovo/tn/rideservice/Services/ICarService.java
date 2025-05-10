package com.droovo.tn.rideservice.Services;

import com.droovo.tn.rideservice.DTO.CarDto;
import com.droovo.tn.rideservice.Entities.Enum.CarStatus;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface ICarService {
    CarDto createCar(CarDto carDto);
    CarDto getCarById(String uid);
    CarDto updateCar(String uid, Map<Object,Object> fields);
    boolean deleteCar(String uid);
    Iterable<CarDto> getAllCars();
    Iterable<CarDto> getCarsByStatus(CarStatus status);
    Page<CarDto> getCarsAndPage(int page, int size);
}
