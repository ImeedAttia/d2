package com.droovo.tn.rideservice.DTO;

/**
 * GeoPointDto is a Data Transfer Object representing a geographic coordinate.
 * <p>
 * This record is used to encapsulate the latitude and longitude of a specific location,
 * commonly used for mapping pickup and destination points in ride-related operations.
 * <p>
 * Fields:
 * <ul>
 *   <li>{@code latitude} – The latitude coordinate.</li>
 *   <li>{@code longitude} – The longitude coordinate.</li>
 * </ul>
 */
public record GeoPointDto(
        double latitude,
        double longitude
) {}

