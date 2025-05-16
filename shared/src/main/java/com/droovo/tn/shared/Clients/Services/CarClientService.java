package com.droovo.tn.shared.Clients.Services;

import com.droovo.tn.shared.Clients.CarClient;
import com.droovo.tn.shared.dto.CarDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarClientService {

    private final CarClient carClient;
    public CarClientService(CarClient rideClient) {
        this.carClient = rideClient;
    }

    public CarDTO getCarById(String rideId) {
        return carClient.getCarById(rideId);
    }

    public List<CarDTO> getAllCars() {
        return carClient.getAllCars();
    }
}
