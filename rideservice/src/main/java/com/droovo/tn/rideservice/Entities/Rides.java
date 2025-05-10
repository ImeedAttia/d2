package com.droovo.tn.rideservice.Entities;

import com.droovo.tn.rideservice.DTO.UserDetail;
import com.droovo.tn.rideservice.Entities.Enum.RideStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Document(collection = "rides")
@Data
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rides {
    @Id
    @Indexed
    @Setter(AccessLevel.MODULE)
    String uid;
    @DBRef(lazy = true)
    List<UserDetail> passengers;
    String destination;
    UserDetail driver;
    String phone;
    String pickUp;
    double price;
    int remainingPassengers;
    int requestedPassengers;
    Date rideTime;
    Date rideTimeLastModified;
    @DBRef(lazy = true)
    private Car car;
    @DBRef(lazy = true)
    RideTargetSourceLocation rideTargetSourceLocation;
    RideStatus rideStatus;
    String groupChat;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
