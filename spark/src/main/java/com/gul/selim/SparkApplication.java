package com.gul.selim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SparkApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(SparkApplication.class, args);
		
		SparkKafkaEngine engine = new SparkKafkaEngine(ctx.getEnvironment());		
		engine.start();
	}
}
