package com.droovo.tn.rideservice.kafka;

import com.droovo.tn.rideservice.DTO.CarClientDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CarKafkaConsumer {

    @KafkaListener(topics = "car-topic", groupId = "ride-group")
    public void consumeCar(CarClientDto car) {
        System.out.println("Received car from Kafka: " + car);
    }
}
