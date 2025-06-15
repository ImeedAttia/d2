package com.droovo.tn.shared.Fallback;

public class UserFallback {
    // This class can be used to provide fallback methods for user-related operations
    // when the primary service is unavailable or fails.
    //add logger
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserFallback.class);


    public String getUserById(String userId) {
        // Log the fallback action
        logger.warn("Fallback method called for user with ID: {}", userId);
        return "Fallback response for user with ID: " + userId;
    }

    // Additional fallback methods can be added as needed
    public String getAllUsers() {
        // Log the fallback action for default user
        logger.warn("Fallback method called for default user");
        return "Default User";
    }
}
