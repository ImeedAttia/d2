package com.droovo.tn.shared.Services;

import com.droovo.tn.shared.config.JwtService;
import com.droovo.tn.shared.dto.Auth.AuthenticationRequest;
import com.droovo.tn.shared.dto.Auth.AuthenticationResponse;
import com.droovo.tn.shared.dto.Auth.RegisterRequest;
import com.droovo.tn.shared.dto.ENUM.TypeUser;
import com.droovo.tn.shared.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = UserDTO.builder()
                .email(registerRequest.getEmail())
                .displayName(registerRequest.getDisplayName())
                .type(registerRequest.getRole())
                .status(true)
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .type(TypeUser.USER)
                .build();
//        UserDTO userResponse =  userDetailRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwt).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        //var user = userDetailRepository.findByEmail(authenticationRequest.getEmail()).orElse(null);
        UserDTO user = UserDTO.builder()
                .email(authenticationRequest.getEmail())
                .password(authenticationRequest.getPassword())
                .build();
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwt).build();
    }
    public AuthenticationResponse authenticateWithuserId(UserDTO user) {
        //var user = userDetailRepository.findById((long) userId).orElse(null);
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwt).build();
    }
//    public AuthenticationResponse forgetPassword(ForgotPasswordRequest forgotPasswordRequest) {
//        Utilisateur user = utilisateurRepository.findByEmail(forgotPasswordRequest.getEmail())
//        UserDetail user = userDetailRepository.findByEmail(forgotPasswordRequest.getEmail())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        String newPassword = generateRandomPassword();
//
//        user.setPassword(passwordEncoder.encode(newPassword));
//        utilisateurRepository.save(user);
//        userDetailRepository.save(user);
//
//        emailService.sendPasswordResetEmail(user.getEmail(), newPassword);
//
//        return AuthenticationResponse.builder().message("Password reset successful. Check your email for the new password.").build();
//    }

    private String generateRandomPassword() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

}