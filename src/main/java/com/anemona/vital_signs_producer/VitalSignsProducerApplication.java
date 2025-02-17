package com.anemona.vital_signs_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VitalSignsProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitalSignsProducerApplication.class, args);
	}
 
}
