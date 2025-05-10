package com.droovo.tn.rideservice.DTO;

import com.droovo.tn.rideservice.Entities.Enum.SeatStatus;

import java.time.LocalDateTime;

/**
 * SeatDto is a Data Transfer Object representing a seat entity.
 * <p>
 * This record is used to transfer seat data between application layers, such as between
 * services and controllers. It provides a simplified, immutable representation of a seat.
 * </p>
 *
 * <p>Fields:
 * <ul>
 *   <li>{@code uid} - Unique identifier for the seat.</li>
 *   <li>{@code status} - Current status of the seat (e.g., AVAILABLE, RESERVED).</li>
 *   <li>{@code reservedBy} - Identifier of the user who reserved the seat, if any.</li>
 *   <li>{@code createdAt} - Timestamp when the seat was created.</li>
 *   <li>{@code updatedAt} - Timestamp when the seat was last updated.</li>
 * </ul>
 * </p>
 */
public record SeatDto(
        int uid,
        SeatStatus status,
        String reservedBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
