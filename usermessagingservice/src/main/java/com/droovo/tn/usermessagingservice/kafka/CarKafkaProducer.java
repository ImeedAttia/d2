package com.droovo.tn.usermessagingservice.kafka;

import com.droovo.tn.usermessagingservice.Entites.shared.CarClientDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CarKafkaProducer {

    private final KafkaTemplate<String, CarClientDto> kafkaTemplate;

    public CarKafkaProducer(KafkaTemplate<String, CarClientDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendCar(CarClientDto car) {
        kafkaTemplate.send("car-topic", car);
    }
}
