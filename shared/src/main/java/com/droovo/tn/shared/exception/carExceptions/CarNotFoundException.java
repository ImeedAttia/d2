package com.droovo.tn.shared.exception.carExceptions;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(String patientId) {
        super("User not found with ID: " + patientId);
    }
}