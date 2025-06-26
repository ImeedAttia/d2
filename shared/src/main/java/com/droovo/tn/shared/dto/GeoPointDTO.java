package com.droovo.tn.shared.dto;

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
public record GeoPointDTO(
        double latitude,
        double longitude
) {
    public GeoPointDTO() {
        this(0.0, 0.0);
    }

    public GeoPointDTO(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

