package com.droovo.tn.rideservice.Services.Services;

import com.droovo.tn.rideservice.DTO.RideDto;
import com.droovo.tn.rideservice.Entities.Enum.RideStatus;
import com.droovo.tn.rideservice.Entities.RideTargetSourceLocation;
import com.droovo.tn.rideservice.Entities.Rides;
import com.droovo.tn.rideservice.Mappers.RidesMapper;
import com.droovo.tn.rideservice.Repositories.RidesRepository;
import com.droovo.tn.rideservice.Services.IRideService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "RideServiceImpl")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RideServiceImpl implements IRideService {
    final RidesRepository ridesRepository;
    final RidesMapper ridesMapper;

    @Override
    public RideDto createRide(RideDto rideDto) {
        log.info("Creating a new Ride with details: {}", rideDto);
        // Map the RideDto to Ride entity
        Rides car = ridesMapper.toEntity(rideDto);
        // Save the Ride entity to the repository
        Rides savedRide = ridesRepository.save(car);
        log.info("Ride created successfully with ID: {}", savedRide.getUid());
        // Map the saved Ride entity back to RideDto
        return ridesMapper.toDto(savedRide);
    }

    @Override
    public RideDto getRideById(String uid) {
        log.info("Fetching Ride with ID: {}", uid);
        // Fetch the Ride entity from the repository
        Rides ride = ridesRepository.findById(uid).orElse(null);
        if (ride == null) {
            log.warn("Ride with ID: {} not found", uid);
            return null;
        }
        log.info("Ride fetched successfully: {}", ride);
        // Map the Ride entity to RideDto
        return ridesMapper.toDto(ride);
    }

    @Override
    public boolean deleteRide(String uid) {
        log.info("Deleting Ride with ID: {}", uid);
        // Delete the Ride entity from the repository
        ridesRepository.deleteById(uid);
        log.info("Ride with ID: {} deleted successfully", uid);
        return ridesRepository.existsById(uid);
    }

    @Override
    public RideDto updateRide(String uid, Map<Object, Object> fields) {
        log.info("Updating Ride with ID: {}", uid);
        // Fetch the Ride entity from the repository
        Rides ride = ridesRepository.findById(uid).orElse(null);
        if (ride == null) {
            log.warn("Ride with ID: {} not found", uid);
            return null;
        }
        // Update the Ride entity with the provided fields
        fields.forEach((key, value) -> {
            switch (key.toString()) {
                case "rideTimeLastModified" -> ride.setRideTimeLastModified((Date) value);
                case "rideTime" -> ride.setRideTime((Date) value);
                case "remainingPassengers" -> ride.setRemainingPassengers((int) value);
                case "requestedPassengers" -> ride.setRequestedPassengers((int) value);
                case "rideStatus" -> ride.setRideStatus((RideStatus) value);
                case "price" -> ride.setPrice((double) value);
                case "rideTargetSourceLocation" -> ride.setRideTargetSourceLocation((RideTargetSourceLocation) value);
                case "destination" -> ride.setDestination((String) value);
                case "phone" -> ride.setPhone((String) value);
                case "pickUp" -> ride.setPickUp((String) value);
                case "groupChat" -> ride.setGroupChat((String) value);
                case "updatedAt" -> ride.setUpdatedAt((LocalDateTime) value);
                // Default case for unknown fields
                default -> log.warn("Unknown field: {}", key);
            }
        });
        // Save the updated Ride entity to the repository
        Rides updatedRide = ridesRepository.save(ride);
        log.info("Ride updated successfully: {}", updatedRide);
        // Map the updated Ride entity to RideDto
        return ridesMapper.toDto(updatedRide);
    }

    @Override
    public Iterable<RideDto> getAllRides() {
        log.info("Fetching all rides");
        // Fetch all Ride entities from the repository
        List<Rides> rides = ridesRepository.findAll();
        // Handle the case when no rides are found
        if (rides.isEmpty()) {
            log.warn("No rides found");
            return new ArrayList<>();
        }
        //check if the rides are empty
        if (rides.iterator().hasNext()) {
            log.warn("No rides found");
            return new ArrayList<>();
        }
        log.info("Rides found : {}", rides);

        // Map the list of Ride entities to a list of RideDto
        ArrayList<RideDto> rideDtos = new ArrayList<>();
        for (Rides ride : rides) {
            RideDto rideDto = ridesMapper.toDto(ride);
            rideDtos.add(rideDto);
        }
        return rideDtos;
    }

    @Override
    public Page<RideDto> getRidesByPage(int page, int size) {
        log.info("Fetching rides with pagination: page = {}, size = {}", page, size);
        // Fetch paginated Ride entities from the repository
        Page<Rides> ridesPage = ridesRepository.findAll(PageRequest.of(page, size));
        // Handle the case when no rides are found
        if (ridesPage.isEmpty()) {
            log.warn("No rides found");
            return null;
        }
        log.info("Rides found : {}", ridesPage.getContent());
        // Map the paginated list of Ride entities to a paginated list of RideDto
        return ridesPage.map(ridesMapper::toDto);
    }
}
