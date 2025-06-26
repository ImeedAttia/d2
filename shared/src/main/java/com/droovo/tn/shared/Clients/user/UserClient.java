package com.droovo.tn.shared.Clients.user;

import com.droovo.tn.shared.Fallback.UserFallback;
import com.droovo.tn.shared.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "userservice", url = "${user.service.url}",fallback = UserFallback.class)
public interface UserClient {
    @GetMapping("/userdetails/{id}")
    UserDTO getUserById(@PathVariable("id") String carId);

    @GetMapping("/userdetails")
    List<UserDTO> getAllUsers();
}
