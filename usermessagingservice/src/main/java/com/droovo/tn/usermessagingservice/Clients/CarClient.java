package com.droovo.tn.usermessagingservice.Clients;

import com.droovo.tn.usermessagingservice.Entites.shared.CarClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "carservice", url = "${ride.service.url}")
public interface CarClient {
    @GetMapping("/cars/{carId}")
    CarClientDto getCarById(@PathVariable("carId") String carId);
}
