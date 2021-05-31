package com.gul.selim;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

public class BeanDefinitions {

	@Bean
	@ConfigurationProperties(prefix = "mycustomobject")
	public MyCustomObject getMyCustomObject() {
		return new MyCustomObject();
	}
}
