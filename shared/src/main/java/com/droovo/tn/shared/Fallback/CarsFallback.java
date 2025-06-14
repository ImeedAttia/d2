package com.droovo.tn.shared.Fallback;

import com.droovo.tn.shared.Clients.ride.CarClient;
import com.droovo.tn.shared.dto.CarDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class CarsFallback implements CarClient {

    private static final Logger logger = Logger.getLogger(CarsFallback.class.getName());
    @Override
    public CarDTO getCarById(String carId) {
        // Return a default CarDTO or null to signify fallback and log
        logger.warning("Fallback triggered for getCarById with carId: " + carId);
        return new CarDTO(); // Or return null if appropriate
    }

    @Override
    public List<CarDTO> getAllCars() {
        CarDTO car = new CarDTO();
        List<CarDTO> cars = new ArrayList<>();
        cars.add(car);
        return cars;
    }
}
