package com.droovo.tn.rideservice.Entities;

import com.droovo.tn.rideservice.DTO.GeoPointDto;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "ride_target_source_location")
@Data
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RideTargetSourceLocation {
    @Id
    @Indexed
    @Setter(AccessLevel.MODULE)
    int uid;
    LocationDetails pickupLocation;
    LocationDetails destinationLocation;
    GeoPointDto pickupGeoPoint;
    GeoPointDto destinationGeoPoint;
    double distance;
}
