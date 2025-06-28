package com.droovo.tn.rideservice.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarClientDto {
    String uid;
    String brand;
    String model;
    String color;
    String plateNumber;
    String carType;
    String carImageUrl;
    String driverUid;
    String groupChat;
    String carStatus;
    String createdAt;
    String updatedAt;
}
