package com.example.openfeign.service;

import java.util.List;

import com.example.openfeign.model.Post;

public interface JSONPlaceHolderService {
    List<Post> getPosts();

    Post getPostById(Long id);
}
