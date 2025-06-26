package com.droovo.tn.shared.exception.userExceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String patientId) {
        super("User not found with ID: " + patientId);
    }
}