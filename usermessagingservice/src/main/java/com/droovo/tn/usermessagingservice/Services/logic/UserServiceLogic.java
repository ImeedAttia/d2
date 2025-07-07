package com.droovo.tn.usermessagingservice.Services.logic;

import com.droovo.tn.usermessagingservice.Entites.Enum.UserStatus;
import com.droovo.tn.usermessagingservice.Entites.UserDetail;
import com.droovo.tn.usermessagingservice.Repositories.UserDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceLogic {
    // Inject the UserDetail repository for DB access
    private final UserDetailRepository userDetailRepository;

    /**
     * Retrieves a UserDetail by userId from the database.
     *
     * @param userId the unique identifier of the user
     * @return UserDetail object if found, otherwise an empty UserDetail instance
     */
    public UserDetail getUserById(String userId) {
        Optional<UserDetail> userOpt = userDetailRepository.findById(userId);
        // Return found user or empty user if not found
        return userOpt.orElseGet(UserDetail::empty);
    }

    /**
     * Updates the status of the user identified by userId.
     *
     * @param userId the unique identifier of the user
     * @param status the new UserStatus to set
     */
    public void setStatus(String userId, UserStatus status) {
        Optional<UserDetail> userOpt = userDetailRepository.findById(userId);
        if (userOpt.isPresent()) {
            UserDetail user = userOpt.get();
            // Set the new status on the user entity
            user.setUserStatus(status);
            // Save the updated user back to the database
            userDetailRepository.save(user);
        }
        // You might want to handle the case where user is not found
    }

    //getFavoriteLocations

}
