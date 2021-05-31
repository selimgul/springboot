package com.gul.selim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/

@SpringBootApplication
@EnableJpaAuditing
public class JpaRepositoryApplication {

	public static void main(String[] args) {

		SpringApplication.run(JpaRepositoryApplication.class, args);
	}

}
