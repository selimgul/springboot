package com.example.jpamappings.repository;

import com.example.jpamappings.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository  extends CrudRepository<Author, Long> {
}
