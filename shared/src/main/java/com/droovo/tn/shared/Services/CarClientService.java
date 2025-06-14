package com.droovo.tn.shared.Services;

import com.droovo.tn.shared.Clients.ride.CarClient;
import com.droovo.tn.shared.dto.CarDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarClientService {

    private final CarClient carClient;

    public CarClientService(CarClient carClient) {
        this.carClient = carClient;
    }
    @CircuitBreaker(name = "carClientCircuitBreaker", fallbackMethod = "getCarByIdFallback")
    public CarDTO getCarById(String carId) {
        return carClient.getCarById(carId);
    }
    @CircuitBreaker(name = "carClientCircuitBreaker", fallbackMethod = "getAllCarsFallback")
    public List<CarDTO> getAllCars() {
        return carClient.getAllCars();
    }
}
