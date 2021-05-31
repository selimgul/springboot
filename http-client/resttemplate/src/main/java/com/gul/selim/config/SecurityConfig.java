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
public class SecurityConfig {
	
	  @Value("${http.auth.basic.user}")
	  String basicAuthUser;
}
