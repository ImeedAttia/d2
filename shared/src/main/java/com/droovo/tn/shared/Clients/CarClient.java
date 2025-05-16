package com.droovo.tn.shared.Clients;

import com.droovo.tn.shared.dto.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "carervice", url = "${ride.service.url}")
public interface CarClient {
    @GetMapping("/cars/{carId}")
    CarDTO getCarById(@PathVariable("carId") String carId);

    @GetMapping("/cars")
    List<CarDTO> getAllCars();
}
