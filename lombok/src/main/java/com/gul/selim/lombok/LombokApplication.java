package com.gul.selim.lombok;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://springframework.guru/spring-boot-with-lombok-part-1/
// https://examples.javacodegeeks.com/spring-boot-with-lombok/
// https://javabydeveloper.com/lombok-spring-boot-example/

// @Data, @Value
// @Getter, @Setter
// @NoArgsConstructor,  @AllArgsConstructor, @RequiredArgsContructor
// @Slf4j
// @Builder
// @NonNull

@SpringBootApplication
@Slf4j
public class LombokApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LombokApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = User.builder().id(1).name("selim").build();
		log.info(user.getName());
	}

}
