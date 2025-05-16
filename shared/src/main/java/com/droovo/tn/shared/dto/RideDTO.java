package com.droovo.tn.shared.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RideDTO {
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