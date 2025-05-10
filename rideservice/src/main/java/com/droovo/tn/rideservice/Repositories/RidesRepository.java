package com.droovo.tn.rideservice.Repositories;

import com.droovo.tn.rideservice.Entities.Rides;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RidesRepository extends MongoRepository<Rides, String> {
    Optional<Rides> findById(String uid);
}
