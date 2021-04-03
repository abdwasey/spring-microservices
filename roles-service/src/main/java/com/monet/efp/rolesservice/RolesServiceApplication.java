package com.monet.efp.rolesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RolesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RolesServiceApplication.class, args);
	}

}
