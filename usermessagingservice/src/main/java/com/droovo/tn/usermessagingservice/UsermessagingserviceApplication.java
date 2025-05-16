package com.droovo.tn.usermessagingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
    @EnableFeignClients
public class UsermessagingserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsermessagingserviceApplication.class, args);
    }

}
