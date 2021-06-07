package com.example.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

// https://www.baeldung.com/spring-cache-tutorial

@SpringBootApplication
@EnableCaching
public class CacheableApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheableApplication.class, args);
	}

}
