package com.droovo.tn.rideservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.droovo.tn.shared")
public class RideserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(RideserviceApplication.class, args);
	}

}
