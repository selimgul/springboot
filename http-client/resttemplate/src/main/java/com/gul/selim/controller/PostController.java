package com.gul.selim.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gul.selim.model.Post;

@Validated
@RequestMapping(value = "/api/v1/post")
public interface PostController {

	@GetMapping
	ResponseEntity<List<Post>> getPosts();
	
	@GetMapping(value="/{id}")
	ResponseEntity<Post> getPostById(@PathVariable String id);
	
	@PostMapping
	ResponseEntity<Post> createPost(@RequestBody Post post);
}
