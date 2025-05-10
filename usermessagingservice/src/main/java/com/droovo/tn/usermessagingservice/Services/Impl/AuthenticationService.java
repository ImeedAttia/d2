package com.droovo.tn.usermessagingservice.Services.Impl;


<<<<<<< HEAD
=======
import com.droovo.tn.usermessagingservice.Entites.UserDetail;
import com.droovo.tn.usermessagingservice.Repositories.UserDetailRepository;
>>>>>>> rebuild
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.droovo.tn.usermessagingservice.Entites.Auth.AuthenticationRequest;
import com.droovo.tn.usermessagingservice.Entites.Auth.AuthenticationResponse;
import com.droovo.tn.usermessagingservice.Entites.Auth.RegisterRequest;
import com.droovo.tn.usermessagingservice.Entites.Enum.TypeUser;
<<<<<<< HEAD
import com.droovo.tn.usermessagingservice.Entites.Utilisateur;
import com.droovo.tn.usermessagingservice.Repositories.UtilisateurRepository;
=======
>>>>>>> rebuild
import com.droovo.tn.usermessagingservice.Services.EmailService;
import com.droovo.tn.usermessagingservice.config.JwtService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
<<<<<<< HEAD
    private final UtilisateurRepository utilisateurRepository;
=======
    private final UserDetailRepository userDetailRepository;
>>>>>>> rebuild
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final EmailService emailService;
    public AuthenticationResponse register(RegisterRequest registerRequest) {
<<<<<<< HEAD
        var user = Utilisateur.builder()
=======
        var user = UserDetail.builder()
>>>>>>> rebuild
                .email(registerRequest.getEmail())
                .displayName(registerRequest.getDisplayName())
                .type(registerRequest.getRole())
                .status(true)
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .type(TypeUser.USER)
                .build();
<<<<<<< HEAD
        Utilisateur userResponse =  utilisateurRepository.save(user);
=======
        UserDetail userResponse =  userDetailRepository.save(user);
>>>>>>> rebuild
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
<<<<<<< HEAD
        var user = utilisateurRepository.findByEmail(authenticationRequest.getEmail()).orElse(null);
=======
        var user = userDetailRepository.findByEmail(authenticationRequest.getEmail()).orElse(null);
>>>>>>> rebuild
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwt).build();
    }
    public AuthenticationResponse authenticateWithuserId(long userId) {
<<<<<<< HEAD
        var user = utilisateurRepository.findById((long) userId).orElse(null);
=======
        var user = userDetailRepository.findById((long) userId).orElse(null);
>>>>>>> rebuild
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwt).build();
    }
//    public AuthenticationResponse forgetPassword(ForgotPasswordRequest forgotPasswordRequest) {
<<<<<<< HEAD
//        Utilisateur user = utilisateurRepository.findByEmail(forgotPasswordRequest.getEmail())
=======
//        UserDetail user = userDetailRepository.findByEmail(forgotPasswordRequest.getEmail())
>>>>>>> rebuild
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        String newPassword = generateRandomPassword();
//
//        user.setPassword(passwordEncoder.encode(newPassword));
<<<<<<< HEAD
//        utilisateurRepository.save(user);
=======
//        userDetailRepository.save(user);
>>>>>>> rebuild
//
//        emailService.sendPasswordResetEmail(user.getEmail(), newPassword);
//
//        return AuthenticationResponse.builder().message("Password reset successful. Check your email for the new password.").build();
//    }

    private String generateRandomPassword() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

}