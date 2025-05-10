package com.droovo.tn.usermessagingservice.Controller.Authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.droovo.tn.usermessagingservice.Entites.Auth.AuthenticationRequest;
import com.droovo.tn.usermessagingservice.Entites.Auth.AuthenticationResponse;
import com.droovo.tn.usermessagingservice.Entites.Auth.RegisterRequest;
import com.droovo.tn.usermessagingservice.Services.Impl.AuthenticationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
    @PostMapping("/authenticate/{userId}")
    public ResponseEntity<AuthenticationResponse> authenticate(@PathVariable long userId) {
        return ResponseEntity.ok(authenticationService.authenticateWithuserId(userId));
    }

}
