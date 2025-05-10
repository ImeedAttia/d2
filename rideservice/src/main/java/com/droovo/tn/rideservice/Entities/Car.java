package com.droovo.tn.rideservice.Entities;

import com.droovo.tn.rideservice.Entities.Enum.CarStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "cars")
@Data
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {

    @Id
    @Indexed
    @Setter(AccessLevel.MODULE)
    String uid;
    String brand;
    String model;
    String description;
    String carNo;
    String color;
    @DBRef
    List<Seat> seats;
    double fuelCons;
    int doors;
    boolean airConditioner;
    String image;
    CarStatus status;
    int possibleSeats;
    @DBRef
    List<Rides> rides;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}

