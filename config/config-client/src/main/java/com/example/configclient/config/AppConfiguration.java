package com.example.configclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@RefreshScope
@Data
public class AppConfiguration {
    
    @Value("${spring.rabbitmq.host:Not Set}")
    private String rabbitmqHost;

}
