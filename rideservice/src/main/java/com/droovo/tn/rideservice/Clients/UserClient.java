package com.droovo.tn.rideservice.Clients;

import com.droovo.tn.rideservice.DTO.UserDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(value = "userserivce", url = "${user.service.url}")
public interface UserClient {
    @GetMapping("/user/{userId}")
    UserDetail getUserById(@PathVariable("userId") String userId);
}
