package com.gul.selim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigurationApplication implements ApplicationRunner {

	@Autowired
	private MyCustomObject mco;

	@Autowired
	private MailConfig mc;

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println(mco.getUsername());
		System.out.println(mco.getPassword());
		System.out.println(mco.getTimeout());

		System.out.println(mc.getFrom());
		System.out.println(mc.getSubject());
		System.out.println(mc.getBody());

		for (String to : mc.getTo()) {
			System.out.println(to);
		}
	}

}
