package com.gul.selim;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResttemplateApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(ResttemplateApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		/*
		 * Properties props = System.getProperties(); props.put("http.proxyHost",
		 * httpProxyHost); props.put("http.proxyPort", httpProxyPort);
		 * props.put("https.proxyHost", httpProxyHost); props.put("https.proxyPort",
		 * httpProxyPort);
		 */

	}

}
