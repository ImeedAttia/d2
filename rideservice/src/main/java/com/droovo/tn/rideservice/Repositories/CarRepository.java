package com.droovo.tn.rideservice.Repositories;

import com.droovo.tn.rideservice.Entities.Car;
import com.droovo.tn.rideservice.Entities.Enum.CarStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String> {
    Iterable<Car> findByStatus(CarStatus status);
    boolean existsByCarNo(String carNo);
}
