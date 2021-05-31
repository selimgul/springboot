package com.gul.selim.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.gul.selim.controller.PostController;
import com.gul.selim.model.Post;
import com.gul.selim.service.PostService;

@RestController
public class PostControllerImpl extends ControllerBaseImpl implements PostController {
	
	@Autowired
	private PostService postService;

	@Override
	public ResponseEntity<List<Post>> getPosts() {
		return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Post> getPostById(String id) {
		return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Post> createPost(Post post) {
		return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
	}

}
