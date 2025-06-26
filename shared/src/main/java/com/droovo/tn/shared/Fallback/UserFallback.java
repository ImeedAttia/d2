package com.droovo.tn.shared.Fallback;

import com.droovo.tn.shared.Clients.user.UserClient;
import com.droovo.tn.shared.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserFallback  implements UserClient {
    // This class can be used to provide fallback methods for user-related operations
    // when the primary service is unavailable or fails.
    // add logger
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserFallback.class);


    public UserDTO getUserById(String userId) {
        // Log the fallback action
        logger.warn("Fallback method called for user with ID: {}", userId);
        return new UserDTO(); // Return a default UserDTO or null to signify fallback
    }

    // Additional fallback methods can be added as needed
    public List<UserDTO> getAllUsers() {
        // Log the fallback action for default user
        logger.warn("Fallback method called for default user");
        return List.of(new UserDTO()); // Return a list with a default UserDTO or an empty list
    }
}
