package com.droovo.tn.shared.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarDTO {
    String uid;
    String brand;
    String model;
    String description;
    String carNo;
    String color;
    double fuelCons;
    int doors;
    boolean airConditioner;
    String image;
    int possibleSeats;
}
