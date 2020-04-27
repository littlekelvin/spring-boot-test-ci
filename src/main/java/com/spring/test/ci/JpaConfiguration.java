package com.spring.test.ci;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing(auditorAwareRef = "auditAware")
@EnableJpaRepositories(basePackages = "com.spring.test.ci.repository")
public class JpaConfiguration {
}
