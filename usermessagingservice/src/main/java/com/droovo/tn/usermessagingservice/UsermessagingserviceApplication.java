package com.droovo.tn.usermessagingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan("com.droovo.tn.shared")
public class UsermessagingserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsermessagingserviceApplication.class, args);
    }

}
