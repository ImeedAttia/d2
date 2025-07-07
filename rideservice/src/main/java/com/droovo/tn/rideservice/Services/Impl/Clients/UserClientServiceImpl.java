package com.droovo.tn.rideservice.Services.Impl.Clients;

import com.droovo.tn.rideservice.Clients.UserClient;
import com.droovo.tn.rideservice.DTO.UserDetail;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

@Service
public class UserClientServiceImpl {

    private final UserClient userClient;
    public UserClientServiceImpl(UserClient carClient) {
        this.userClient = carClient;
    }

    public UserDetail fetchUser(String userId) {
        return userClient.getUserById(userId);
    }
}
