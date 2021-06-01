package com.example.openfeign.controller;

import java.util.List;

import com.example.openfeign.model.Post;
import com.example.openfeign.service.JSONPlaceHolderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    
    @Autowired
    private JSONPlaceHolderService jsonPlaceHolderService;

    @GetMapping("/api/posts")
    public List<Post> getPosts(){
        return jsonPlaceHolderService.getPosts();        
    }

    @GetMapping("/api/posts/{id}")
    public Post getPosts(@PathVariable final Long id){
        return jsonPlaceHolderService.getPostById(id);        
    }
}
