package com.gul.selim.config;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpHost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Value(value = "${http.proxy.host}")
	private String httpProxyHost;

	@Value(value = "${http.proxy.port}")
	private String httpProxyPort;

	@Bean
	public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		return new RestTemplate(getClientHttpRequestFactory());
	}

	private HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		//SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();

		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(
			HttpClientBuilder.create()
			.setProxy(new HttpHost(httpProxyHost, Integer.parseInt(httpProxyPort), "http"))
			.build()
		);

		// Connect timeout
		requestFactory.setConnectTimeout(10_000);

		// Read timeout
		requestFactory.setReadTimeout(10_000);

		// SSL
		CloseableHttpClient httpClient = HttpClients.custom()
		  											.setSSLHostnameVerifier(new NoopHostnameVerifier())
		  											.build();
													  
	  	requestFactory.setHttpClient(httpClient);

		return requestFactory;
	}	

	// private ClientHttpRequestFactory getClientHttpRequestFactory() {
	// 	SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();

	// 	// Connect timeout
	// 	clientHttpRequestFactory.setConnectTimeout(10_000);

	// 	// Read timeout
	// 	clientHttpRequestFactory.setReadTimeout(10_000);

	// 	// Set proxy
	// 	clientHttpRequestFactory.setProxy(new Proxy(Type.HTTP, new InetSocketAddress(httpProxyHost, Integer.parseInt(httpProxyPort))));

	// 	return clientHttpRequestFactory;
	// }	
}
