package com.droovo.tn.rideservice.Services.Services;

import com.droovo.tn.rideservice.DTO.CarDto;
import com.droovo.tn.rideservice.DTO.UserDetail;
import com.droovo.tn.rideservice.Entities.Car;
import com.droovo.tn.rideservice.Entities.Enum.CarStatus;
import com.droovo.tn.rideservice.Entities.Enum.SeatStatus;
import com.droovo.tn.rideservice.Entities.Seat;
import com.droovo.tn.rideservice.Mappers.CarMapper;
import com.droovo.tn.rideservice.Repositories.CarRepository;
import com.droovo.tn.rideservice.Services.ICarService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
=======
import org.springframework.util.Assert;
>>>>>>> rebuild
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * CarServiceImpl is a service class that implements the ICarService interface.
 * It provides methods to manage car entities, including creating, retrieving,
 * updating, and deleting cars, as well as filtering by user ID and status.
 */

@Service
@RequiredArgsConstructor
@Slf4j(topic = "CarServiceImpl")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarServiceImpl implements ICarService {
    final CarRepository carRepository;
    final CarMapper carMapper;

    @Override
    public CarDto createCar(CarDto carDto) {
        log.info("Creating a new car with details: {}", carDto);
        // Map the CarDto to Car entity
        Car car = carMapper.toEntity(carDto);
        //check the car
        if (carRepository.existsByCarNo(car.getCarNo())) {
            log.warn("Car creation failed: Car number already exists");
            return null;
        }
<<<<<<< HEAD
=======
        Assert.isTrue(!carRepository.existsByCarNo(car.getCarNo()), "Car number cannot be null");
>>>>>>> rebuild

        if (car.getDescription() == null || car.getColor() == null || car.getFuelCons() == 0.0) {
            log.warn("Car creation failed: Missing required fields");
            return null;
        }
        car.setCreatedAt(LocalDateTime.now());
        car.setUpdatedAt(LocalDateTime.now());
        // Set the car status to AVAILABLE
        car.setStatus(CarStatus.AVAILABLE);
        car.setSeats(createCarSeats());
        // Save the car entity to the repository
        Car savedCar = carRepository.save(car);
        log.info("Car created successfully with ID: {}", savedCar.getUid());
        // Map the saved car entity back to CarDto
        return carMapper.toDto(savedCar);
    }

    @Override
    public CarDto getCarById(String id) {
        log.info("Fetching car with ID: {}", id);
        // Find the car by ID
        Car car = carRepository.findById(id).orElse(null);
        if (car == null) {
            log.warn("Car with ID: {} not found", id);
            return null;
        }
        log.info("Car found: {}", car);
        // Map the found car entity to CarDto
        return carMapper.toDto(car);
    }

    @Override
    public CarDto updateCar(String uid, Map<Object,Object> fields) {
        log.info("Updating car with ID: {}", uid);
        // Find the car by ID
        Car car = carRepository.findById(uid).orElse(null);
        if (car == null) {
            log.warn("Car with ID: {} not found", uid);
            return null;
        }
        // Update the car entity with the provided fields
        fields.forEach((key, value) -> {
            switch (key.toString()) {
                case "description" -> car.setDescription(value.toString());
                case "color" -> car.setColor(value.toString());
                case "fuelCons" -> car.setFuelCons(Double.parseDouble(value.toString()));
                case "airConditioner" -> car.setAirConditioner(Boolean.parseBoolean(value.toString()));
                case "image" -> car.setImage(value.toString());
                case "status" -> car.setStatus(CarStatus.valueOf(value.toString()));
            }
        });
        // Save the updated car entity to the repository
        Car updatedCar = carRepository.save(car);
        log.info("Car updated successfully with ID: {}", updatedCar.getUid());
        // Map the updated car entity back to CarDto
        return carMapper.toDto(updatedCar);
    }

    @Override
    public boolean deleteCar(String uid) {
        log.info("Deleting car with ID: {}", uid);
        // Delete the car by ID
        carRepository.deleteById(uid);
        log.info("Car with ID: {} deleted successfully", uid);
        return carRepository.existsById(uid);
    }

    @Override
    public Iterable<CarDto> getAllCars() {
        log.info("Fetching all cars");
        // Find all cars
        Iterable<Car> cars = carRepository.findAll();
        // Check if the cars collection is empty
        if (!cars.iterator().hasNext()) {
            log.warn("No cars found");
            return null;
        }
        log.info("Cars found: {}", cars);
        // Convert each car entity to CarDto using the mapper
        List<CarDto> carDtoList = new ArrayList<>();
        for (Car car : cars) {
            carDtoList.add(carMapper.toDto(car));
        }
        // Return the list of CarDto
        return carDtoList;
    }

    @Override
    public Iterable<CarDto> getCarsByStatus(CarStatus status) {
        log.info("Fetching cars with status: {}", status);
        // Find cars by status
        Iterable<Car> cars = carRepository.findByStatus(status);
        // Check if the cars collection is empty
        if (!cars.iterator().hasNext()) {
            log.warn("No cars found with status: {}", status);
            return null;
        }
        log.info("Cars found with status: {}: {}", status, cars);
        // Convert each car entity to CarDto using the mapper
        List<CarDto> carDtoList = new ArrayList<>();
        for (Car car : cars) {
            carDtoList.add(carMapper.toDto(car));
        }
        // Return the list of CarDto
        return carDtoList;
    }

    @Override
    public Page<CarDto> getCarsAndPage(int page, int size) {
        log.info("Fetching cars with pagination: page {}, size {}", page, size);

        // Find cars with pagination
        Page<Car> carPage = carRepository.findAll(PageRequest.of(page, size));

        // Check if the carPage is empty
        if (carPage.isEmpty()) {
            log.warn("No cars found");
            return Page.empty();  // Return an empty Page if no cars are found
        }

        log.info("Cars found: {}", carPage);

        // Convert each car entity to CarDto using the mapper
        List<CarDto> carDtoList = new ArrayList<>();
        for (Car car : carPage.getContent()) {
            carDtoList.add(carMapper.toDto(car));
        }

        // Return the page of CarDto
        return new PageImpl<>(carDtoList, carPage.getPageable(), carPage.getTotalElements());
    }

    public static boolean checkCarAndSeats(UserDetail user) {
        if (user.getCar() == null || user.getCar().isEmpty()) return false;

        for (Car car : user.getCar()) {
            if (car.getStatus() != CarStatus.AVAILABLE) continue;
            if (ObjectUtils.isEmpty(car.getBrand()) || ObjectUtils.isEmpty(car.getCarNo())) continue;

            List<Seat> seats = car.getSeats();
            int totalCarSeats = (seats != null) ? seats.size() : 0;
            int sharedSeats = car.getPossibleSeats();

            if (sharedSeats > 0 && sharedSeats <= totalCarSeats) {
                return true;
            }
        }

        return false;
    }

    public static List<Seat> createCarSeats(){
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Seat seat = new Seat();
            seat.setUid(i + 1);
            if(seat.getUid() == 1){
                seat.setStatus(SeatStatus.LOCKED_FOR_DRIVER);
            }else {
                seat.setStatus(SeatStatus.AVAILABLE);
            }
            seats.add(seat);
        }
        return seats;
    }

}
