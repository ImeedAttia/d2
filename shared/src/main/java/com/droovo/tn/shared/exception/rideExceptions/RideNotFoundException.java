package com.droovo.tn.shared.exception.rideExceptions;

public class RideNotFoundException extends RuntimeException {
    public RideNotFoundException(String patientId) {
        super("Ride not found with ID: " + patientId);
    }
}