package com.gul.selim.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RequestHelper {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HeaderHelper headerHelper;

	public <T> ResponseEntity<T> get(String userNameForAuth, String url, Class<T> responseType) {
		return restTemplate.exchange(url, HttpMethod.GET,
				new HttpEntity<>(headerHelper.buildHttpHeaders(userNameForAuth)), responseType);
	}
	
	public <T> ResponseEntity<T> get(String userNameForAuth, String url, ParameterizedTypeReference<T> responseType) {
		return restTemplate.exchange(url, HttpMethod.GET,
				new HttpEntity<>(headerHelper.buildHttpHeaders(userNameForAuth)), responseType);
	}

	public <T> ResponseEntity<T> post(String userNameForAuth, String url, Object requestBody, Class<T> responseType) {
		return restTemplate.exchange(url, HttpMethod.POST,
				new HttpEntity<>(requestBody, headerHelper.buildHttpHeaders(userNameForAuth)), responseType);
	}
	
	public <T> ResponseEntity<T> post(String userNameForAuth, String url, Object requestBody, ParameterizedTypeReference<T> responseType) {
		return restTemplate.exchange(url, HttpMethod.POST,
				new HttpEntity<>(requestBody, headerHelper.buildHttpHeaders(userNameForAuth)), responseType);
	}

	public <T> ResponseEntity<T> put(String userNameForAuth, String url, Object requestBody, Class<T> responseType) {
		return restTemplate.exchange(url, HttpMethod.PUT,
				new HttpEntity<>(requestBody, headerHelper.buildHttpHeaders(userNameForAuth)), responseType);
	}
	
	public <T> ResponseEntity<T> put(String userNameForAuth, String url, Object requestBody, ParameterizedTypeReference<T>  responseType) {
		return restTemplate.exchange(url, HttpMethod.PUT,
				new HttpEntity<>(requestBody, headerHelper.buildHttpHeaders(userNameForAuth)), responseType);
	}

}
