package com.example.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String sur_name;
    private int age;
    private String fullName;
    private int level;    
}
