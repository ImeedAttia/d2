package com.droovo.tn.shared.Controller.Authentication;

import com.droovo.tn.shared.Services.AuthenticationService;
import com.droovo.tn.shared.dto.Auth.AuthenticationRequest;
import com.droovo.tn.shared.dto.Auth.AuthenticationResponse;
import com.droovo.tn.shared.dto.Auth.RegisterRequest;
import com.droovo.tn.shared.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        UserDTO user = UserDTO.builder()
                .id(userId)
                .build();
        return ResponseEntity.ok(authenticationService.authenticateWithuserId(user));
    }

}
