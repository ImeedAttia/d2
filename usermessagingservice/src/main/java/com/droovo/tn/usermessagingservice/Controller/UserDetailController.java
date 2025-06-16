package com.droovo.tn.usermessagingservice.Controller;
import com.droovo.tn.usermessagingservice.Clients.Services.CarClientService;
import com.droovo.tn.usermessagingservice.Entites.Requests.UserDetailsRequest;
import com.droovo.tn.usermessagingservice.Entites.UserDetail;
import com.droovo.tn.usermessagingservice.Entites.shared.CarClientDto;
import com.droovo.tn.usermessagingservice.Mapper.UserDetailMapper;
import com.droovo.tn.usermessagingservice.Services.EmailService;
import com.droovo.tn.usermessagingservice.Services.UserDetailService;
import com.droovo.tn.usermessagingservice.Validators.UserDetailsValidator;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/userdetails")
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
    public ResponseEntity<UserDetail> createUserDetail(@RequestBody UserDetailsRequest userDetailsRequest) {
        //validate
//        if (UserDetailsValidator.isValidUserDetails(userDetailsRequest)) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        //convert
        UserDetail userDetail = UserDetailMapper.mapToUserDetails(userDetailsRequest);
        //save
        try {
            UserDetail savedUserDetail = userDetailService.saveUserDetail(userDetail);
            return new ResponseEntity<>(savedUserDetail, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error saving user details: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetail> getUserDetailById(@PathVariable String id) {
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
    public ResponseEntity<UserDetail> updateUserDetail(@PathVariable String id, @RequestBody UserDetail utilisateur) {
        UserDetail updatedUserDetail = userDetailService.updateUserDetail(id, utilisateur);
        if (updatedUserDetail != null) {
            return new ResponseEntity<>(updatedUserDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserDetail(@PathVariable String id) {
        userDetailService.deleteUserDetail(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/mail/{userId}")
    public ResponseEntity<String> sendMail(@PathVariable String userId) {
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