package com.droovo.tn.usermessagingservice.Clients;

import com.droovo.tn.usermessagingservice.Entites.shared.RideClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "rideservices", url = "${ride.service.url}")
public interface RideClient {
    @GetMapping("/api/rides/{rideId}")
    RideClientDto getRideById(@PathVariable("rideId") String rideId);
}
