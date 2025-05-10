package com.droovo.tn.usermessagingservice.Entites.shared;

import java.time.Instant;
import java.util.List;

public class RideClientDto {
        String uid;
        String driverUid;
        List<String> passengerUIDs;
        String destination;
        String phone;
        String pickUp;
        double price;
        int remainingPassengers;
        int requestedPassengers;
        Instant rideTime;
        Instant rideTimeLastModified;
        String carUid;
        String groupChat;
        String pickupLocationText;
        String destinationLocationText;
        double pickupLat;
        double pickupLng;
        double destinationLat;
        double destinationLng;
        double distance;
        String rideStatus;
        Instant createdAt;
        Instant updatedAt;
}