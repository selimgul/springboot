package com.gul.selim.service;

import com.gul.selim.model.Post;
import com.gul.selim.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class PostService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PostRepository repository;

    public List<Post> getAll() {

        return repository.findAll();
    }

    public Post get(Integer id) {

        return repository.findById(id).get();
    }

    public void add(Post post) {

        entityManager.getTransaction().begin();
        entityManager.persist(post);
        entityManager.getTransaction().commit();
        repository.save(post);
    }
}
