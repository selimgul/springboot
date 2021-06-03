package com.example.mapstruct.mapper;

import com.example.mapstruct.model.User;
import com.example.mapstruct.model.UserEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper (componentModel = "spring")
public interface UserMapper {
    
    @Mapping(source = "surname", target = "sur_name")
    @Mapping(target="fullName", expression = "java(user.getName()+\" \"+user.getSurname())")
    @Mapping(target = "level", constant = "10")
    User toUser(UserEntity user);

    @Mapping(source = "sur_name", target = "surname")
    UserEntity toUserEntity(User user);
}