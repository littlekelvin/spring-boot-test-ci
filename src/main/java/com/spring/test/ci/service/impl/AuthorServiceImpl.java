package com.spring.test.ci.service.impl;

import com.spring.test.ci.entities.Author;
import com.spring.test.ci.entities.Post;
import com.spring.test.ci.repository.AuthorRepository;
import com.spring.test.ci.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> findAuthorByName(String name) {
        List<Author> authors = authorRepository.findAuthorsByName(name);
        return checkAuthorPosts(authors);
    }

    private List<Author> checkAuthorPosts(List<Author> authors) {
        List<Author> results = new ArrayList<>();
        for (Author author : authors) {
            // aaa
            // aaaa
            List<Post> posts = author.getPosts();
            for (Post post : posts) {
                if (post.getTitle().contains("My Home2")) {
                    results.add(author);
                }
            }
        }
        return results;
    }

    private void tt() {

    }

}
