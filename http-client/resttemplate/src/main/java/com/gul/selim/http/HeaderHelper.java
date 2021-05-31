package com.gul.selim.http;

import java.util.Base64;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class HeaderHelper {

	private static final String AUTH_PREFIX = "Basic  ";

	public HttpHeaders buildHttpHeaders(String userName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, convertUsernameToBase64(userName));
		headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	private String convertUsernameToBase64(String userName) {
		String formattedString = userName.concat(":").concat(userName);
		String encodedString = Base64.getEncoder().encodeToString(formattedString.getBytes());
		return AUTH_PREFIX.concat(encodedString);
	}
}
