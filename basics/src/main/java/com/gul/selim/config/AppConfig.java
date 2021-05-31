package com.gul.selim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.gul.selim.beans.HelloWorld;

@Configuration
@ComponentScan({"com.gul.selim.beans"})
public class AppConfig {
	
	@Bean
	@Scope("prototype")
	public HelloWorld helloWorld(){
		return new HelloWorld();
	}
	
	/*
	  @Bean(name = "speakerService")
	  @Scope(value = BeanDefinition.SCOPE_SINGLETON)
	  public SpeakerService getSpeakerService() {
	    SpeakerServiceImpl service = new SpeakerServiceImpl();
	    //SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
	    //service.setRepository(getSpeakerRepository());
	    return service;
	  }


	  @Bean(name = "speakerRepository")
	  public SpeakerRepository getSpeakerRepository() {
	    return new HibernateSpeakerRepositoryImpl();
	  }
       */
}
