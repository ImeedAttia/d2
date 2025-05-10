package com.droovo.tn.usermessagingservice.Services.Impl;

import com.droovo.tn.usermessagingservice.Entites.UserDetail;
import com.droovo.tn.usermessagingservice.Repositories.UserDetailRepository;
import com.droovo.tn.usermessagingservice.Services.UserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailService {
    private final UserDetailRepository userDetailRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetail saveUserDetail(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }

    @Override
    public UserDetail getUserDetailById(Long id) {
        Optional<UserDetail> utilisateurOptional = userDetailRepository.findById(id);
        return utilisateurOptional.orElse(null);
    }

    @Override
    public UserDetail getUserDetailByEmail(String email) {
        Optional<UserDetail> utilisateurOptional = userDetailRepository.findByEmail(email);
        return utilisateurOptional.orElse(null);
    }

    @Override
    public List<UserDetail> getAllUserDetails() {
        return userDetailRepository.findAll();
    }

    @Override
    public UserDetail updateUserDetail(Long id, UserDetail userDetail) {
        Optional<UserDetail> optionalUtilisateur = userDetailRepository.findById(id);
        if (optionalUtilisateur.isPresent()) {
            UserDetail existingUserDetail = optionalUtilisateur.get();
            existingUserDetail.setDisplayName(userDetail.getDisplayName());
            existingUserDetail.setEmail(userDetail.getEmail());
            existingUserDetail.setPhotoURL(userDetail.getPhotoURL());
            existingUserDetail.setPassword(passwordEncoder.encode(existingUserDetail.getPassword()));
            existingUserDetail.setType(userDetail.getType());
            existingUserDetail.setStatus(userDetail.isStatus());

            return userDetailRepository.save(existingUserDetail);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUserDetail(Long id) {
        userDetailRepository.deleteById(id);
    }

    @Override
    public long countUserDetail() {
        return userDetailRepository.count();
    }

    //get the current loggedIn user
    public static String getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
            // use username or userDetails as needed
        } else {
            username = principal.toString();
            // handle cases where the principal is not an instance of UserDetails
        }
        return username;
    }

}