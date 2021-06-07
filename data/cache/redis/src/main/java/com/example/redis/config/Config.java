package com.example.redis.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class Config {

    @Bean    
    public LettuceConnectionFactory redisConnectionFactory() {        
        RedisStandaloneConfiguration redisConf = new RedisStandaloneConfiguration();
        redisConf.setHostName("localhost");
        redisConf.setPort(6379);
        redisConf.setPassword(RedisPassword.of(""));
        return new LettuceConnectionFactory(redisConf);
    }

    @Bean
    @Qualifier("cacheManagerForTenSec")
    @Primary
    public RedisCacheManager cacheManagerForTenSec() {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(10));
        return RedisCacheManager.builder(redisConnectionFactory()).cacheDefaults(config).transactionAware().build();
    }

    @Bean
    @Qualifier("cacheManagerForOneMin")
    public RedisCacheManager cacheManagerForOneMin() {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(1));
        return RedisCacheManager.builder(redisConnectionFactory()).cacheDefaults(config).transactionAware().build();
    }
}
