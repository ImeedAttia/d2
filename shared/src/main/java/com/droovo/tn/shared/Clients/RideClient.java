package com.droovo.tn.shared.Clients;

import com.droovo.tn.shared.dto.RideDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "rideservice", url = "${ride.service.url}")
public interface RideClient {
    @GetMapping("/api/rides/{rideId}")
    RideDTO getRideById(@PathVariable("rideId") String rideId);
}
