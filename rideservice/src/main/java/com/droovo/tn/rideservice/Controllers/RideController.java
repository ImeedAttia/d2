package com.droovo.tn.rideservice.Controllers;

import com.droovo.tn.rideservice.DTO.RideDto;
import com.droovo.tn.rideservice.Services.IRideService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rides")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RideController {

    private final IRideService rideService;
    /**
     * Creates a new ride.
     *
     * @param rideDto the ride data transfer object containing ride details
     * @return the created ride data transfer object
     */

    @PostMapping
    public ResponseEntity<RideDto> createRide(@RequestBody RideDto rideDto) {
        RideDto createdRide = rideService.createRide(rideDto);
        return new ResponseEntity<>(createdRide, HttpStatus.CREATED);
    }

    /**
     * Retrieves a ride by its unique identifier.
     *
     * @param uid the unique identifier of the ride
     * @return the ride data transfer object if found, otherwise 404 Not Found
     */
    @GetMapping("/{uid}")
    public ResponseEntity<RideDto> getRideById(@PathVariable String uid) {
        RideDto ride = rideService.getRideById(uid);
        return ride != null ? ResponseEntity.ok(ride) : ResponseEntity.notFound().build();
    }

    /**
     * Deletes a ride by its unique identifier.
     *
     * @param uid the unique identifier of the ride
     * @return 204 No Content if deleted successfully, otherwise 404 Not Found
     */
    @DeleteMapping("/{uid}")
    public ResponseEntity<Void> deleteRide(@PathVariable String uid) {
        boolean deleted = rideService.deleteRide(uid);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * Updates a ride by its unique identifier.
     *
     * @param uid    the unique identifier of the ride
     * @param fields the fields to update in the ride
     * @return the updated ride data transfer object if found, otherwise 404 Not Found
     */
    @PatchMapping("/{uid}")
    public ResponseEntity<RideDto> updateRide(@PathVariable String uid, @RequestBody Map<Object, Object> fields) {
        RideDto updatedRide = rideService.updateRide(uid, fields);
        return updatedRide != null ? ResponseEntity.ok(updatedRide) : ResponseEntity.notFound().build();
    }

    /**
     * Retrieves all rides.
     *
     * @return an iterable of ride data transfer objects
     */
    @GetMapping
    public ResponseEntity<Iterable<RideDto>> getAllRides() {
        Iterable<RideDto> rides = rideService.getAllRides();
        return ResponseEntity.ok(rides);
    }

    /**
     * Retrieves rides with pagination.
     *
     * @param page the page number to retrieve
     * @param size the number of rides per page
     * @return a page of ride data transfer objects
     */
    @GetMapping("/page")
    public ResponseEntity<Page<RideDto>> getRidesByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<RideDto> ridePage = rideService.getRidesByPage(page, size);
        return ResponseEntity.ok(ridePage);
    }
}
