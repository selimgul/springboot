package com.gul.selim.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class EndpointConfig {

	@Value("${http.endpoint.employee.get}")
	String getEmployeesEndpoint;

	@Value("${http.endpoint.employee.getbyid}")
	String getEmployeeByIdEndpoint;

	@Value("${http.endpoint.employee.create}")
	String createEmployeeEndpoint;

	@Value("${http.endpoint.posts.get}")
	String getPostsEndpoint;

	@Value("${http.endpoint.posts.getbyid}")
	String getPostByIdEndpoint;

	@Value("${http.endpoint.posts.create}")
	String createPostEndpoint;

}
