package com.spring.test.ci.service;

import com.spring.test.ci.entities.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAuthorByName(String name);
}
