package com.spring.test.ci.repository;

import com.spring.test.ci.base.JpaTestBase;
import com.spring.test.ci.entities.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:/testdb/init-users.sql"})
public class UserRepositoryJpaTest extends JpaTestBase {

    @Autowired
    UserRepository userRepository;

    @Test
    public void should_have_one_user_named_kelvin() {
        User user = userRepository.findByUsername("kelvin");
        assertNotNull(user);
        assertThat(user.getRole()).isEqualTo(1);
    }
}