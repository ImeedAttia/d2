package com.droovo.tn.shared.Services;

import com.droovo.tn.shared.Clients.user.UserClient;
import com.droovo.tn.shared.dto.CarDTO;
import com.droovo.tn.shared.dto.UserDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserClientService {

    private final UserClient userClient;

    public UserClientService(UserClient userClient) {
        this.userClient = userClient;
    }
    @CircuitBreaker(name = "userClientCircuitBreaker", fallbackMethod = "getUserByIdFallback")
    public UserDTO getUserById(String userUid) {
        return userClient.getUserById(userUid);
    }
    @CircuitBreaker(name = "userClientCircuitBreaker", fallbackMethod = "getAllUsersFallback")
    public List<UserDTO> getAllUsers() {
        return userClient.getAllUsers();
    }
}
