package com.spring.test.ci.service.impl;

import com.spring.test.ci.entities.Author;
import com.spring.test.ci.entities.Post;
import com.spring.test.ci.repository.AuthorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceImplUnitTest {
    @Mock
    AuthorRepository authorRepository;
    @InjectMocks
    AuthorServiceImpl authorService;

    @Test
    public void should_return_authors_given_name() {
        when(authorRepository.findAuthorsByName(anyString())).thenReturn(getAuthors());
        List<Author> authors = authorService.findAuthorByName("kelvin");
        assertThat(authors.size()).isEqualTo(0);
    }

    private List<Author> getAuthors() {
        List<Author> authors = new ArrayList<>();
        Post post = Post.builder().title("My Home").body("post body").build();
        List<Post> posts = Arrays.asList(post);
        Author author = Author.builder().name("Kelvin").age(25).gender("male").posts(posts).build();
        authors.add(author);
        return authors;
    }
}