package com.example.redis.service;

import com.example.redis.model.User;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Caching(put = { @CachePut(value = "userCache", key="#id")})
    public User createUser(Long id, String name){
        System.out.println("User is created.");
        return User.builder().id(id).name(name).build();
    }

    @Cacheable(value = "userCache", key="#id", cacheManager = "cacheManagerForTenSec")    
    public User getUser(Long id){

        System.out.println("User is returning from actual data source. #" + id);
        return User.builder().id(id).name("foo").build();
    }

    @Caching(put = { @CachePut(value = "userCache", key="#user.getId()")})
    public User updateUser(User user){
        System.out.println("User #" + user.getId() + " updated.");
        return user;
    }

    @CacheEvict (value = "userCache", key="#user.getId()")
    public void deleteUser(User user){
        System.out.println("User #" + user.getId() + " deleted.");        
    }
}
