package io.github.vikie1.portfolio.projects.betterdevs.repository;

import io.github.vikie1.portfolio.projects.betterdevs.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsRepository extends JpaRepository<Topic, Long> {
    Topic getByNameAllIgnoreCase(String name);
    boolean existsByNameAllIgnoreCase(String name);
}
