package io.github.vikie1.portfolio.admin.authorities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepo extends JpaRepository<AuthoritiesEntity, String> {
    void deleteByUsername(String username);
}
