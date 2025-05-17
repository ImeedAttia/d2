package com.droovo.tn.shared.Clients.Fallback;

import com.droovo.tn.shared.Clients.CarClient;
import com.droovo.tn.shared.dto.CarDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CarsFallback implements CarClient {

    @Override
    public CarDTO getCarById(String carId) {
        // Return a default CarDTO or null to signify fallback and log
        //logger.warn("Fallback triggered for getCarById with carId: {}", carId);

        CarDTO car = new CarDTO();
        car.setCarNo("00000");
        return car; // Or return null if appropriate
    }

    @Override
    public List<CarDTO> getAllCars() {
        CarDTO car = new CarDTO();
        car.setCarNo("00000");
        List<CarDTO> cars = new ArrayList<>();
        cars.add(car);
        return cars;
    }
}
