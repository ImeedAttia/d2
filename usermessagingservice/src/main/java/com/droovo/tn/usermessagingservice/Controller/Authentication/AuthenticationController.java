package com.droovo.tn.usermessagingservice.Controller.Authentication;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.droovo.tn.usermessagingservice.Entites.Auth.AuthenticationRequest;
import com.droovo.tn.usermessagingservice.Entites.Auth.AuthenticationResponse;
import com.droovo.tn.usermessagingservice.Entites.Auth.RegisterRequest;
import com.droovo.tn.usermessagingservice.Services.Impl.AuthenticationService;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
@Slf4j(topic = "AuthenticationController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationController {
    final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
    @PostMapping("/authenticate/{userId}")
    public ResponseEntity<AuthenticationResponse> authenticate(@PathVariable String userId) {
        return ResponseEntity.ok(authenticationService.authenticateWithuserId(userId));
    }

}
