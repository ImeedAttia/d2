package com.droovo.tn.usermessagingservice.Clients.Services;

import com.droovo.tn.usermessagingservice.Clients.CarClient;
import com.droovo.tn.usermessagingservice.Entites.shared.CarClientDto;
import org.springframework.stereotype.Service;

@Service
public class CarClientService {

    private final CarClient carClient;
    public CarClientService(CarClient carClient) {
        this.carClient = carClient;
    }

    public CarClientDto fetchRide(String rideId) {
        return carClient.getCarById(rideId);
    }
}
