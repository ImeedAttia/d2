package com.droovo.tn.usermessagingservice.Controller;

import com.droovo.tn.usermessagingservice.Entites.shared.CarClientDto;
import com.droovo.tn.usermessagingservice.kafka.CarKafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaSendController {

    private final CarKafkaProducer producer;

    public KafkaSendController(CarKafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/car")
    public String sendCar(@RequestBody CarClientDto car) {
        producer.sendCar(car);
        return "Car sent to Kafka topic";
    }
}
