package com.droovo.tn.rideservice.Mappers.impl;

import com.droovo.tn.rideservice.DTO.CarDto;
import com.droovo.tn.rideservice.DTO.UserDetail;
import com.droovo.tn.rideservice.Entities.Car;
import com.droovo.tn.rideservice.Mappers.CarMapper;
import com.droovo.tn.rideservice.Services.Impl.Clients.UserClientServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CarMapperImpl implements CarMapper {
    private UserClientServiceImpl userClientService;
    @Override
    public CarDto toDto(Car car) {
        UserDetail user = userClientService.fetchUser(car.getDriver());
        return new CarDto(
                car.getUid(),
                car.getBrand(),
                car.getModel(),
                car.getDescription(),
                car.getCarNo(),
                car.getColor(),
                car.getFuelCons(),
                car.getDoors(),
                car.isAirConditioner(),
                car.getImage(),
                car.getPossibleSeats(),
                user
        );
    }

    @Override
    public Car toEntity(CarDto carDto) {
        Car car = new Car();
        car.setBrand(carDto.brand());
        car.setModel(carDto.model());
        car.setDescription(carDto.description());
        car.setCarNo(carDto.carNo());
        car.setColor(carDto.color());
        car.setFuelCons(carDto.fuelCons());
        car.setDoors(carDto.doors());
        car.setAirConditioner(carDto.airConditioner());
        car.setImage(carDto.image());
        car.setPossibleSeats(carDto.possibleSeats());
        if (carDto.driver() != null && carDto.driver().getUid() != null && !carDto.driver().getUid().isEmpty()) {
            car.setDriver(carDto.driver().getUid());
        }
        return car;
    }
}
