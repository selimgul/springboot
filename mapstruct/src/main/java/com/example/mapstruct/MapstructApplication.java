package com.example.mapstruct;

import com.example.mapstruct.mapper.UserMapper;
import com.example.mapstruct.model.UserEntity;
import com.example.mapstruct.model.User;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MapstructApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapstructApplication.class, args);		
	}
}
