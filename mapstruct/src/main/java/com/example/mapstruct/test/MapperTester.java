package com.example.mapstruct.test;

import javax.annotation.PostConstruct;

import com.example.mapstruct.mapper.UserMapper;
import com.example.mapstruct.model.User;
import com.example.mapstruct.model.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MapperTester {
    
    @Autowired
	public UserMapper userMapper;

    @PostConstruct
    public void RunTest(){

        log.info("======================= Running Test =======================");

    	UserEntity userDAO = UserEntity.builder().name("selim").surname("gul").age(39).build();
			
		User user = userMapper.toUser(userDAO);
        log.info(user.toString());

        UserEntity entity = userMapper.toUserEntity(user);
        log.info(entity.toString());
    }

}
