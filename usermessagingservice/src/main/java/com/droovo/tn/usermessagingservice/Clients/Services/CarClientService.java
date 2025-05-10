package com.droovo.tn.usermessagingservice.Clients.Services;

import com.droovo.tn.usermessagingservice.Clients.CarClient;
import com.droovo.tn.usermessagingservice.Entites.shared.CarClientDto;
import org.springframework.stereotype.Service;

@Service
public class CarClientService {

    private final CarClient rideClient;
    public CarClientService(CarClient rideClient) {
        this.rideClient = rideClient;
    }

    public CarClientDto fetchRide(String rideId) {
        return rideClient.getCarById(rideId);
    }
}
