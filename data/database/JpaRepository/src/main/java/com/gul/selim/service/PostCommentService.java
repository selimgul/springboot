package com.gul.selim.service;

import com.gul.selim.model.Post;
import com.gul.selim.model.PostComment;
import com.gul.selim.repository.PostCommentRepository;
import com.gul.selim.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCommentService {

    @Autowired
    private PostCommentRepository repository;

    public List<PostComment> getAll() {

        return repository.findAll();
    }

    public PostComment get(Integer id) {

        return repository.findById(id).get();
    }


    public void add(PostComment postComment) {

        repository.save(postComment);
    }
}
