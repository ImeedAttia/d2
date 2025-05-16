package com.droovo.tn.shared.Services;

import com.droovo.tn.shared.dto.CarDTO;
import com.droovo.tn.shared.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
public interface IUserService {
    CarDTO fetchRide(String id);

    UserDTO saveUserDetail(UserDTO utilisateur);

    UserDTO getUserDetailById(Long id);

    UserDTO getUserDetailByEmail(String email);

    List<UserDTO> getAllUserDetails();

    UserDTO updateUserDetail(Long id, UserDTO utilisateur);

    void deleteUserDetail(Long id);

    void sendEmailWithTemplate(UserDTO user);

    long countUserDetail();

    UserDetails loadUserByUsername(String username);
}
