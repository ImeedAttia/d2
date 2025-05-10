package com.droovo.tn.usermessagingservice.Services.Impl;

import com.droovo.tn.usermessagingservice.Entites.UserDetail;
import com.droovo.tn.usermessagingservice.Repositories.UserDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.droovo.tn.usermessagingservice.Entites.Auth.AuthenticationRequest;
import com.droovo.tn.usermessagingservice.Entites.Auth.AuthenticationResponse;
import com.droovo.tn.usermessagingservice.Entites.Auth.RegisterRequest;
import com.droovo.tn.usermessagingservice.Entites.Enum.TypeUser;
import com.droovo.tn.usermessagingservice.Services.EmailService;
import com.droovo.tn.usermessagingservice.config.JwtService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserDetailRepository userDetailRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final EmailService emailService;
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = UserDetail.builder()
                .email(registerRequest.getEmail())
                .displayName(registerRequest.getDisplayName())
                .type(registerRequest.getRole())
                .status(true)
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .type(TypeUser.USER)
                .build();
        UserDetail userResponse =  userDetailRepository.save(user);
        emailService.sendEmailWithTemplate(userResponse);
        var jwt = jwtService.generateToken(userResponse);
        return AuthenticationResponse.builder().token(jwt).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        var user = userDetailRepository.findByEmail(authenticationRequest.getEmail()).orElse(null);
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwt).build();
    }
    public AuthenticationResponse authenticateWithuserId(long userId) {
        var user = userDetailRepository.findById((long) userId).orElse(null);
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