package com.droovo.tn.shared.dto;

import java.time.LocalDateTime;

/**
 * RideTargetSourceLocationDto is a Data Transfer Object representing the location details of a ride.
 * <p>
 * This record is used to transfer pickup and destination location data, along with geographic coordinates and distance,
 * between layers of the application such as controllers and services.
 * <p>
 * Fields:
 * <ul>
 *   <li>{@code uid} - Unique identifier for the location entry.</li>
 *   <li>{@code pickupLocation} - The pickup location details (street, state, country).</li>
 *   <li>{@code destinationLocation} - The destination location details (street, state, country).</li>
 *   <li>{@code pickupGeoPoint} - Geographic coordinates (latitude/longitude) of the pickup point.</li>
 *   <li>{@code destinationGeoPoint} - Geographic coordinates (latitude/longitude) of the destination point.</li>
 *   <li>{@code distance} - The distance between pickup and destination, typically in kilometers.</li>
 *   <li>{@code createdAt} - Timestamp of when the entry was created.</li>
 *   <li>{@code updatedAt} - Timestamp of the last update to the entry.</li>
 * </ul>
 */
public record RideTargetSourceLocationDTO(
        int uid,
        LocationDetailsDTO pickupLocation,
        LocationDetailsDTO destinationLocation,
        GeoPointDTO pickupGeoPoint,
        GeoPointDTO destinationGeoPoint,
        double distance,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public RideTargetSourceLocationDTO() {
        this(0, new LocationDetailsDTO(), new LocationDetailsDTO(), new GeoPointDTO(), new GeoPointDTO(), 0.0, LocalDateTime.now(), LocalDateTime.now());
    }

    public RideTargetSourceLocationDTO(int uid, LocationDetailsDTO pickupLocation, LocationDetailsDTO destinationLocation,
                                       GeoPointDTO pickupGeoPoint, GeoPointDTO destinationGeoPoint, double distance,
                                       LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.uid = uid;
        this.pickupLocation = pickupLocation;
        this.destinationLocation = destinationLocation;
        this.pickupGeoPoint = pickupGeoPoint;
        this.destinationGeoPoint = destinationGeoPoint;
        this.distance = distance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
