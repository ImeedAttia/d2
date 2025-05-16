package com.droovo.tn.shared.Controller;

import com.droovo.tn.shared.Clients.Services.CarClientService;
import com.droovo.tn.shared.Services.IUserService;
import com.droovo.tn.shared.dto.CarDTO;
import com.droovo.tn.shared.dto.UserDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j(topic = "UserDetailController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetailController {
    final IUserService userDetailService;
    final IUserService emailService;
    final CarClientService carClientService;
    @GetMapping("/car/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable String id) {
        CarDTO carClientDto = carClientService.getCarById(id);
        return new ResponseEntity<>(carClientDto, HttpStatus.OK);
    }
    @GetMapping("/car")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        List<CarDTO> carClientDto = carClientService.getAllCars();
        return new ResponseEntity<>(carClientDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUserDetail(@RequestBody UserDTO utilisateur) {
        UserDTO savedUserDetail = userDetailService.saveUserDetail(utilisateur);
        return new ResponseEntity<>(savedUserDetail, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserDetailById(@PathVariable Long id) {
        UserDTO utilisateur = userDetailService.getUserDetailById(id);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserDetailByEmail(@PathVariable String email) {
        UserDTO utilisateur = userDetailService.getUserDetailByEmail(email);
        if (utilisateur != null) {
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUserDetails() {
        List<UserDTO> utilisateurs = userDetailService.getAllUserDetails();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUserDetail(@PathVariable Long id, @RequestBody UserDTO utilisateur) {
        UserDTO updatedUserDetail = userDetailService.updateUserDetail(id, utilisateur);
        if (updatedUserDetail != null) {
            return new ResponseEntity<>(updatedUserDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserDetail(@PathVariable Long id) {
        userDetailService.deleteUserDetail(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/mail/{userId}")
    public ResponseEntity<String> sendMail(@PathVariable long userId) {
        UserDTO user = userDetailService.getUserDetailById(userId);
        emailService.sendEmailWithTemplate(user);
        return new ResponseEntity<String>("Mail sent", HttpStatus.OK);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countUserDetail() {
        long count = userDetailService.countUserDetail();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

}