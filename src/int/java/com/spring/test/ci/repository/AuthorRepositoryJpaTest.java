package com.spring.test.ci.repository;

import com.spring.test.ci.base.JpaTestBase;
import com.spring.test.ci.entities.Author;
import com.spring.test.ci.entities.Post;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorRepositoryJpaTest extends JpaTestBase {
    @Autowired AuthorRepository authorRepository;

    @Test
    public void saveAuthor() {
        List<Post> posts = new ArrayList<>();
        Post post = Post.builder().body("post body").title("My Home").build();
        Post post2 = Post.builder().body("post body2").title("My Home2").build();
        posts.add(post);
        posts.add(post2);
        Author author = Author.builder().name("Jack")
                .gender("female")
                .age(23).posts(posts).build();
        post.setAuthor(author);
        post2.setAuthor(author);
        Author result = authorRepository.save(author);
        assertThat(result.getName()).isEqualTo("Jack");
        assertThat(result.getGender()).isEqualTo("female");
    }

    @Test
    public void should_init_one_author_with_name_kelvin_when_start_embedded_database() {
        List<Author> authors = authorRepository.findAuthorsByName("Kelvin");
        assertThat(authors.size()).isEqualTo(1);
        Author author = authors.get(0);
        assertThat(author.getGender()).isEqualTo("male");
        assertThat(author.getName()).isEqualTo("Kelvin");
        assertThat(author.getAge()).isEqualTo(12);
        assertThat(author.getPosts().size()).isEqualTo(2);
    }
}