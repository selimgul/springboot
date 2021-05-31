package com.gul.selim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication {

	// .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
	// .\bin\windows\kafka-server-start.bat .\config\server.properties
	
	// mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8080
	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

}
