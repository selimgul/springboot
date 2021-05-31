package com.gul.selim.service;

import java.util.List;

import com.gul.selim.model.Post;

public interface PostService {

	List<Post> getPosts();	
	
	Post getPostById(String id);
	
	Post createPost(Post post);
}
