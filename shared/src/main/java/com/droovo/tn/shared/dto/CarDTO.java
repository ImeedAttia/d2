package com.droovo.tn.shared.dto;

/**
 * CarDto is a Data Transfer Object representing a car entity.
 * <p>
 * This record is used to transfer car data between different layers of the application,
 * such as between controllers and services. It encapsulates key car attributes in a
 * compact and immutable format.
 * <p>
 * Fields:
 * <ul>
 * <<<<<<< HEAD
 * =======
 *   <li>{@code uid} - Car manufacturer (e.g., Toyota, Ford).</li>
 * >>>>>>> rebuild
 *   <li>{@code brand} - Car manufacturer (e.g., Toyota, Ford).</li>
 *   <li>{@code model} - Specific model of the car.</li>
 *   <li>{@code description} - Optional description or details about the car.</li>
 *   <li>{@code carNo} - Car's registration number or license plate.</li>
 *   <li>{@code color} - Exterior color of the car.</li>
 *   <li>{@code fuelCons} - Fuel consumption (e.g., liters per 100 km).</li>
 *   <li>{@code doors} - Number of doors in the car.</li>
 *   <li>{@code airConditioner} - Indicates if the car has air conditioning.</li>
 *   <li>{@code image} - Image URL or references for the car.</li>
 *   <li>{@code possibleSeats} - Number of passengers the car can accommodate.</li>
 * </ul>
 */
public record CarDTO(
        String uid,
        String brand,
        String model,
        String description,
        String carNo,
        String color,
        double fuelCons,
        int doors,
        boolean airConditioner,
        String image,
        int possibleSeats
) {
    public CarDTO() {
        this("", "", "", "", "", "", 0.0, 0, false, "", 0);
    }
}


