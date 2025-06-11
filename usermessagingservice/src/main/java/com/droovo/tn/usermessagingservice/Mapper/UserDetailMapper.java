package com.droovo.tn.usermessagingservice.Mapper;

import com.droovo.tn.usermessagingservice.Entites.Enum.TypeUser;
import com.droovo.tn.usermessagingservice.Entites.Enum.UserStatus;
import com.droovo.tn.usermessagingservice.Entites.Requests.UserDetailsRequest;
import com.droovo.tn.usermessagingservice.Entites.UserDetail;

/**
 * Mapper class to convert UserDetailsRequest to UserDetail entity.
 * This class is responsible for mapping the fields from the request object
 * to the UserDetail entity used in the application.
 */
public class UserDetailMapper {
    /**
     * Maps UserDetailsRequest to UserDetail entity.
     *
     * @param userDetailsRequest the request object containing user details
     * @return a UserDetail object populated with the data from the request
     */
    public static UserDetail mapToUserDetails(UserDetailsRequest userDetailsRequest) {
        //use builder of UserDetails to create UserDetails object
        return UserDetail.builder()
                .id(userDetailsRequest.getId())
                .uid(userDetailsRequest.getUid())
                .cin(userDetailsRequest.getCin())
                .displayName(userDetailsRequest.getDisplayName())
                .email(userDetailsRequest.getEmail())
                .photoURL(userDetailsRequest.getPhotoURL())
                .phone(userDetailsRequest.getPhone())
                .isVerified(userDetailsRequest.isVerified())
                .password(userDetailsRequest.getPassword())
                .status(true) // default status is online
                .accountStatus(true) // default account status is active
                .type(TypeUser.USER) // default type is USER
                .userStatus(UserStatus.UNKNOWN) // default user status is UNKNOWN
                .lastLogin(new java.sql.Timestamp(System.currentTimeMillis())) // set last login to current time
                .plan("FREE") // default plan is FREE
                .isDriver(false) // default is not a driver
                .build();
    }
}
