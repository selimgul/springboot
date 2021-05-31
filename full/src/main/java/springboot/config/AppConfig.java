package springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

	//@LoadBalanced // Discovery Server kullanılması durumunda @LoadBalanced eklenmelidir.
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate(getClientHttpRequestFactory());
		//return new RestTemplate();
	}

	private ClientHttpRequestFactory getClientHttpRequestFactory()
	{
	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
	                      = new HttpComponentsClientHttpRequestFactory();
	    //Connect timeout
	    clientHttpRequestFactory.setConnectTimeout(10_000);
	     
	    //Read timeout
	    clientHttpRequestFactory.setReadTimeout(10_000);
	    return clientHttpRequestFactory;
	}
	
	@Bean
	public WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}
}