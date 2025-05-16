package com.droovo.tn.shared.Services.impl;

import com.droovo.tn.shared.Services.IUserService;
import com.droovo.tn.shared.dto.CarDTO;
import com.droovo.tn.shared.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Override
    public CarDTO fetchRide(String id) {
        // Logic to fetch ride by ID
        // This is a placeholder implementation
        CarDTO carDTO = new CarDTO();
        carDTO.setUid(id);
        return carDTO;
    }

    @Override
    public UserDTO saveUserDetail(UserDTO utilisateur) {
        return new UserDTO();
    }

    @Override
    public UserDTO getUserDetailById(Long id) {
        return new UserDTO();
    }

    @Override
    public UserDTO getUserDetailByEmail(String email) {
        return new UserDTO();
    }

    @Override
    public List<UserDTO> getAllUserDetails() {
        return new ArrayList<>();
    }

    @Override
    public UserDTO updateUserDetail(Long id, UserDTO utilisateur) {
        return new UserDTO();
    }

    @Override
    public void deleteUserDetail(Long id) {
        // Logic to delete user detail by ID
        // This is a placeholder implementation
        System.out.println("User with ID " + id + " deleted.");
    }

    @Override
    public void sendEmailWithTemplate(UserDTO user) {
        // Logic to send email with template
        // This is a placeholder implementation
        System.out.println("Email sent to " + user.getEmail());
    }

    @Override
    public long countUserDetail() {
        return 0;
    }

    @Override
    public UserDTO loadUserByUsername(String username) {
        UserDTO user = new UserDTO();
        user.setEmail(username);
        return user;
    }
}
