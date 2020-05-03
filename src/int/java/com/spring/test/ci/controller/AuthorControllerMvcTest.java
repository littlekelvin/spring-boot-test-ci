package com.spring.test.ci.controller;

import com.spring.test.ci.base.WebMvcTestBase;
import com.spring.test.ci.entities.Author;
import com.spring.test.ci.entities.Post;
import com.spring.test.ci.service.AuthorService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(AuthorController.class)
public class AuthorControllerMvcTest extends WebMvcTestBase {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AuthorService authorService;

    @Test
    public void should_return_authors_reponse_dto_given_author_name() throws Exception {
        when(authorService.findAuthorByName("Kelvin")).thenReturn(getAuthors());
        MvcResult mvcResult = mockMvc.perform(get("/author/Kelvin")).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("{\"success\":true,\"errMsg\":null,\"data\":[{\"createBy\":null,\"createDate\":null,\"lastUpdateBy\":null,\"lastUpdateDate\":null,\"id\":null,\"name\":\"Kelvin\",\"age\":25,\"posts\":[{\"createBy\":null,\"createDate\":null,\"lastUpdateBy\":null,\"lastUpdateDate\":null,\"id\":null,\"title\":\"My Home\",\"body\":\"post body\"}],\"gender\":\"male\"}]}");
    }

    private List<Author> getAuthors() {
        List<Author> authors = new ArrayList<>();
        Post post = Post.builder().title("My Home").body("post body").build();
        List<Post> posts = Arrays.asList(post);
        Author author = Author.builder().name("Kelvin").age(25).gender("male").posts(posts).build();
        authors.add(author);
        return authors;
    }

    @Test
    public void should_return_hello_given_name() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/hello/Kelvin")).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("hello, Kelvin");
    }
}