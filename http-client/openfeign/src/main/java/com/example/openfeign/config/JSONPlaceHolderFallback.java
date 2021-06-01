package com.example.openfeign.config;

import java.util.Collections;
import java.util.List;

import com.example.openfeign.client.JSONPlaceHolderClient;
import com.example.openfeign.model.Post;

public class JSONPlaceHolderFallback implements JSONPlaceHolderClient{

	@Override
	public List<Post> getPosts() {		
		return Collections.emptyList();
	}

	@Override
	public Post getPostById(Long postId) {		
		return null;
	}
    
}
