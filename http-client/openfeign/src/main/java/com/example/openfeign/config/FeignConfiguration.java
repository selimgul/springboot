package com.example.openfeign.config;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.ssl.SSLContexts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Client;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;

@Configuration
public class FeignConfiguration {

    @Bean
    public Client feignClient() {        
       return new Client.Proxied(getSSLSocketFactory(), null,
                new Proxy(Proxy.Type.HTTP, new InetSocketAddress("gmproxy.kfs.local", 8080)));            
    }

    private SSLSocketFactory getSSLSocketFactory() {
        try {
            TrustStrategy acceptingTrustStrategy = new TrustStrategy() {         

                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;                    
                }
            };
    
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
            return sslContext.getSocketFactory();
        } catch (Exception exception) {
        }
        return null;
    }
    
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("user",     "selim");
            requestTemplate.header("password", "gul");
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
        };
    }   

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}