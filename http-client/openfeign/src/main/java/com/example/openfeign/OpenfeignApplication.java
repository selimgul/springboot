package com.example.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// https://www.baeldung.com/spring-cloud-openfeign
// https://github.com/eugenp/tutorials/tree/master/spring-cloud/spring-cloud-openfeign

@SpringBootApplication
@EnableFeignClients
public class OpenfeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenfeignApplication.class, args);
	}

}
