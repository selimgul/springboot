package com.example.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*

https://www.baeldung.com/spring-boot-actuators
@incelenebilir: cache, metrics, usr/pwd ile security

Config dosyasında info ile başlayan free style bilgileri actuator ile gösterebiliriz.
Pom.xml'deki bilgileri @@ arasında ekleyebiliriz. @project.version@

http://localhost:8080/actuator/info
-----------------------------------------------------------------------------------------

HealthIndicator interface'ini implemente eden class'lar ile sağlık kontrolüne
eklentiler yapılabilir.

http://localhost:8080/actuator/health
-----------------------------------------------------------------------------------------

Logger seviyeleri runtime'da değiştirilebilir.

http://localhost:8080/actuator/loggers

http://localhost:8080/actuator/loggers/com.example.actuator.InfoController
POST: {"configuredLevel": "TRACE"}

-----------------------------------------------------------------------------------------
*/


@SpringBootApplication
public class ActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorApplication.class, args);
	}

}
