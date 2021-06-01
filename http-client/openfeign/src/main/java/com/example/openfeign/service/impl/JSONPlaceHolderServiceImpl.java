package com.example.openfeign.service.impl;

import java.util.List;

import com.example.openfeign.client.JSONPlaceHolderClient;
import com.example.openfeign.model.Post;
import com.example.openfeign.service.JSONPlaceHolderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JSONPlaceHolderServiceImpl implements JSONPlaceHolderService {

    @Autowired
    private JSONPlaceHolderClient jsonPlaceHolderClient;

    @Override
    public List<Post> getPosts() {
        return jsonPlaceHolderClient.getPosts();
    }

    @Override
    public Post getPostById(Long id) {
        System.out.println("post id: " + id );
        return jsonPlaceHolderClient.getPostById(id);
    }
}