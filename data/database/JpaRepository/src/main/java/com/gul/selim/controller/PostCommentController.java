package com.gul.selim.controller;

import com.gul.selim.model.Post;
import com.gul.selim.model.PostComment;
import com.gul.selim.service.PostCommentService;
import com.gul.selim.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class PostCommentController {

	@Autowired
	private PostCommentService commentService;

	@Autowired
	private PostService postService;

	@GetMapping
	public List<PostComment> getAll() {

		return commentService.getAll();
	}

	@GetMapping("/{id}")
	public PostComment getComment(@PathVariable("id") Integer id) {

		return commentService.get(id);
	}

	@PostMapping("/{postID}")
	public String add(@PathVariable("postID") Integer postID, @RequestBody PostComment comment) {

		Post post = postService.get(postID);
		comment.setPost(post);
		commentService.add(comment);

		return "Created.";
	}

}
