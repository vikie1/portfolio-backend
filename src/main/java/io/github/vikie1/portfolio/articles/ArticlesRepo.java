package io.github.vikie1.portfolio.articles;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ArticlesRepo extends CrudRepository<Articles, Integer>{
    Optional<Articles> findByTopic(String topic);
}
