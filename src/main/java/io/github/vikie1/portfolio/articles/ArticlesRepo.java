package io.github.vikie1.portfolio.articles;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticlesRepo extends JpaRepository<Articles, Long> {
    List<Articles> findAllByTopic(String topic);
}
