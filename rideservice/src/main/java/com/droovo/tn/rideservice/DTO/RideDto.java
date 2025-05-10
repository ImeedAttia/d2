package com.droovo.tn.rideservice.DTO;

import java.time.Instant;
import java.util.List;

/**
 * RideDto is a Data Transfer Object representing a ride entity.
 * <p>
 * This record is used to transfer ride data between different layers of the application,
 * such as between controllers and services. It encapsulates key ride attributes in a
 * compact and immutable format.
 * <p>
 * Fields:
 * <ul>
 *   <li>{@code uid} - Unique identifier for the ride.</li>
 *   <li>{@code driverUid} - UID of the driver.</li>
 *   <li>{@code passengerUIDs} - List of UIDs of passengers.</li>
 *   <li>{@code destination} - Ride destination.</li>
 *   <li>{@code phone} - Contact number associated with the ride.</li>
 *   <li>{@code pickUp} - Pickup address or location name.</li>
 *   <li>{@code price} - Price of the ride.</li>
 *   <li>{@code remainingPassengers} - Number of available seats.</li>
 *   <li>{@code requestedPassengers} - Total requested passengers.</li>
 *   <li>{@code rideTime} - Scheduled time for the ride.</li>
 *   <li>{@code rideTimeLastModified} - Last modification time of the ride schedule.</li>
 *   <li>{@code carUid} - UID of the assigned car.</li>
 *   <li>{@code groupChat} - ID or reference to associated group chat.</li>
 *   <li>{@code pickupLocationText} - Human-readable pickup location.</li>
 *   <li>{@code destinationLocationText} - Human-readable destination location.</li>
 *   <li>{@code pickupLat} - Latitude of pickup location.</li>
 *   <li>{@code pickupLng} - Longitude of pickup location.</li>
 *   <li>{@code destinationLat} - Latitude of destination.</li>
 *   <li>{@code destinationLng} - Longitude of destination.</li>
 *   <li>{@code distance} - Distance in kilometers/miles.</li>
 *   <li>{@code rideStatus} - Current status of the ride (e.g., pending, completed).</li>
 *   <li>{@code createdAt} - Timestamp when the ride was created.</li>
 *   <li>{@code updatedAt} - Timestamp when the ride was last updated.</li>
 * </ul>
 */
public record RideDto(
        String uid,
        String driverUid,
        List<String> passengerUIDs,
        String destination,
        String phone,
        String pickUp,
        double price,
        int remainingPassengers,
        int requestedPassengers,
        Instant rideTime,
        Instant rideTimeLastModified,
        String carUid,
        String groupChat,
        String pickupLocationText,
        String destinationLocationText,
        double pickupLat,
        double pickupLng,
        double destinationLat,
        double destinationLng,
        double distance,
        String rideStatus,
        Instant createdAt,
        Instant updatedAt
) {
}
