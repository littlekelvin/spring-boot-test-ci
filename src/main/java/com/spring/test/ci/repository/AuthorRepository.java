package com.spring.test.ci.repository;

import com.spring.test.ci.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findAuthorsByName(String name);
}
