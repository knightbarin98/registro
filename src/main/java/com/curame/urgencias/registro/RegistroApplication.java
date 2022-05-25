package com.curame.urgencias.registro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RegistroApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroApplication.class, args);
	}

}
