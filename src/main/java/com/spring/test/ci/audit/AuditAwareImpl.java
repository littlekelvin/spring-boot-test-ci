package com.spring.test.ci.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
@Component("auditAware")
public class AuditAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(UserContextHolder.getUserInfo().getUsername());
    }
}
