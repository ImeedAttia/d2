package com.droovo.tn.shared.Clients.ride;

import com.droovo.tn.shared.dto.RideDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "rideservice", url = "http://localhost:8092/droovo/rideservices")
public interface RideClient {
    @GetMapping("/api/rides/{rideId}")
    RideDTO getRideById(@PathVariable("rideId") String rideId);
}
