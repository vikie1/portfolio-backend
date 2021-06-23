package io.github.vikie1.portfolio.articles;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArticlesRepo extends CrudRepository<Articles, String>{
    List<Articles> findByName(String name);
}
