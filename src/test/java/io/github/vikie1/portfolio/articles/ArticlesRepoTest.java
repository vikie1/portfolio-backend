package io.github.vikie1.portfolio.articles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class ArticlesRepoTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private ArticlesRepo articlesRepo;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void dependenciesAreNotNull() {
        assertNotNull(dataSource);
        assertNotNull(articlesRepo);
        assertNotNull(entityManager);
        assertNotNull(jdbcTemplate);
    }

    @Test
    void findAllArticles() {
        Articles articles = new Articles();
        articles.setName("Test");
        articles.setDescription("Test");
        articles.setTopic("Java");
        articlesRepo.save(articles);
        assertNotNull(articlesRepo.findAllByTopic("Java"));
    }
}