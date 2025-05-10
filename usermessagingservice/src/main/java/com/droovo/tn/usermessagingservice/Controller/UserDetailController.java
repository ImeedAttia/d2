package com.droovo.tn.usermessagingservice.Controller;
import com.droovo.tn.usermessagingservice.Clients.CarClient;
import com.droovo.tn.usermessagingservice.Clients.ReclamationClient;
import com.droovo.tn.usermessagingservice.Clients.Services.CarClientService;
import com.droovo.tn.usermessagingservice.Entites.UserDetail;
import com.droovo.tn.usermessagingservice.Entites.shared.CarClientDto;
import com.droovo.tn.usermessagingservice.Services.EmailService;
import com.droovo.tn.usermessagingservice.Services.UserDetailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j(topic = "UserDetailController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetailController {
    final UserDetailService userDetailService;
    final EmailService emailService;
    final CarClientService carClientService;
    @GetMapping("/car/{id}")
    public ResponseEntity<CarClientDto> getCarById(@PathVariable String id) {
        CarClientDto carClientDto = carClientService.fetchRide(id);
        return new ResponseEntity<>(carClientDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDetail> createUserDetail(@RequestBody UserDetail utilisateur) {
        UserDetail savedUserDetail = userDetailService.saveUserDetail(utilisateur);
        return new ResponseEntity<>(savedUserDetail, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetail> getUserDetailById(@PathVariable Long id) {
        UserDetail utilisateur = userDetailService.getUserDetailById(id);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDetail> getUserDetailByEmail(@PathVariable String email) {
        UserDetail utilisateur = userDetailService.getUserDetailByEmail(email);
        if (utilisateur != null) {
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDetail>> getAllUserDetails() {
        List<UserDetail> utilisateurs = userDetailService.getAllUserDetails();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetail> updateUserDetail(@PathVariable Long id, @RequestBody UserDetail utilisateur) {
        UserDetail updatedUserDetail = userDetailService.updateUserDetail(id, utilisateur);
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
        UserDetail user = userDetailService.getUserDetailById(userId);
        emailService.sendEmailWithTemplate(user);
        return new ResponseEntity<String>("Mail sent", HttpStatus.OK);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countUserDetail() {
        long count = userDetailService.countUserDetail();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

}