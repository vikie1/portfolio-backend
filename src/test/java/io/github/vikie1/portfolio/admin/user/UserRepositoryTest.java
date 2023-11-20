package io.github.vikie1.portfolio.admin.user;

import io.github.vikie1.portfolio.auth.user.UserEntity;
import io.github.vikie1.portfolio.auth.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.persistence.EntityManager;
import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void dependenciesAreNotNull(){
        assertNotNull(dataSource);
        assertNotNull(userRepository);
        assertNotNull(entityManager);
        assertNotNull(jdbcTemplate);
    }
    @Test
    void canPerformCRUDOperations() {
        UserEntity user = new UserEntity();
        user.setUsername("vikie");
        user.setPassword("password");
        user.setEnabled(false);
        UserEntity user2 = new UserEntity();
        user2.setUsername("deleted");
        user2.setPassword("password");
        user2.setEnabled(false);
        userRepository.save(user);
        userRepository.save(user2);
        assertNotNull(userRepository.findByUsername("vikie").orElse(null));
        assertNotNull(userRepository.findByUsername("deleted").orElse(null));
        userRepository.deleteByUsername("deleted");
        assertNull(userRepository.findByUsername("deleted").orElse(null));
    }
}