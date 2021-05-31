package com.gul.selim.controller;

import com.gul.selim.model.Post;
import com.gul.selim.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService service;

	@GetMapping
	public List<Post> getAll() {

		return service.getAll();
	}

	@GetMapping("/{id}")
	public Post getPost(@PathVariable("id") Integer id) {

		return service.get(id);
	}

	@PostMapping
	public String add(@RequestBody Post post) {

		service.add(post);

		return "Created";
	}

}
