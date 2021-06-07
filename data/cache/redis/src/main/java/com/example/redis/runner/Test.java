package com.example.redis.runner;

import com.example.redis.model.User;
import com.example.redis.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Test implements CommandLineRunner{

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        
        User user = userService.createUser(1L, "selim");
        System.out.println(user.toString());

        user = userService.getUser(1L);
        System.out.println(user.toString());

        user.setName("bar");        
        userService.updateUser(user);

        user = userService.getUser(1L);
        System.out.println(user.toString());

        user = userService.getUser(10L);
        System.out.println(user.toString());

        userService.deleteUser(user);

        user = userService.getUser(10L);
        System.out.println(user.toString());
    }
    
}
