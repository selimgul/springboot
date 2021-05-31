package springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	
	@Value("${pattern.cors}")
	private String corsPattern;
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping(corsPattern);
	}

}