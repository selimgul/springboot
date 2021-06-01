package com.example.openfeign.model;

import lombok.Data;

@Data
public class Post {
    private String userId;
    private Long id;
    private String title;
    private String body;
}
