package com.droovo.tn.shared.dto;

import java.time.Instant;

/**
 * FeedbackDto is a Data Transfer Object representing user feedback on a ride.
 * <p>
 * This record is used to transfer feedback data between different layers of the application,
 * encapsulating user comments, ratings, and associated ride information.
 * <p>
 * Fields:
 * <ul>
 *   <li>{@code uid} – Unique identifier for the feedback entry.</li>
 *   <li>{@code userName} – Name of the user providing the feedback.</li>
 *   <li>{@code rating} – Rating score given by the user.</li>
 *   <li>{@code comment} – Additional feedback or comments.</li>
 *   <li>{@code rideId} – Identifier of the ride the feedback is about.</li>
 *   <li>{@code timestamp} – Time when the feedback was submitted.</li>
 * </ul>
 */
public record FeedbackDTO(
        String uid,
        String userName,
        int rating,
        String comment,
        RideDTO ride,
        Instant timestamp
) {}
