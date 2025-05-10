package com.droovo.tn.rideservice.Controllers;

import com.droovo.tn.rideservice.DTO.CarDto;
import com.droovo.tn.rideservice.Services.ICarService;
<<<<<<< HEAD
=======
import jakarta.validation.Valid;
>>>>>>> rebuild
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * CarController handles HTTP requests related to car operations.
 * It provides endpoints for creating, retrieving, updating, and deleting cars.
 */

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarController {

    final ICarService carService;

    /**
     * Creates a new car.
     *
     * @param carDto the car details
     * @return the created car
     */
    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto carDto) {
=======
    public ResponseEntity<CarDto> createCar(@Valid @RequestBody CarDto carDto) {
>>>>>>> rebuild
        log.info("Creating new car");
        return ResponseEntity.ok(carService.createCar(carDto));
    }

    /**
     * Retrieves a car by its ID.
     *
     * @param uid the car ID
     * @return the car details
     */
    @GetMapping("/{uid}")
    public ResponseEntity<CarDto> getCarById(@PathVariable String uid) {
        log.info("Fetching car with ID: {}", uid);
        CarDto carDto = carService.getCarById(uid);
        return ResponseEntity.ok(carDto);
    }

    /**
     * Updates a car by its ID.
     *
     * @param uid    the car ID
     * @param fields the fields to update
     * @return the updated car
     */
    @PatchMapping("/{uid}")
    public ResponseEntity<CarDto> updateCar(@PathVariable String uid, @RequestBody Map<Object, Object> fields) {
        log.info("Updating car with ID: {}", uid);
        return ResponseEntity.ok(carService.updateCar(uid, fields));
    }

    /**
     * Deletes a car by its ID.
     *
     * @param uid the car ID
     * @return a response indicating success or failure
     */
    @DeleteMapping("/{uid}")
    public ResponseEntity<Void> deleteCar(@PathVariable String uid) {
        log.info("Deleting car with ID: {}", uid);
        boolean deleted = carService.deleteCar(uid);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * Retrieves all cars.
     *
     * @return a list of all cars
     */
    @GetMapping
    public ResponseEntity<Iterable<CarDto>> getAllCars() {
        log.info("Fetching all cars");
        return ResponseEntity.ok(carService.getAllCars());
    }
}
