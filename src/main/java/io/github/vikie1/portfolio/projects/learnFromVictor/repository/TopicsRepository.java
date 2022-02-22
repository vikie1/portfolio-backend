package io.github.vikie1.portfolio.projects.learnFromVictor.repository;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TopicsRepository extends JpaRepository<Topic, Long> {
    Topic getByNameAllIgnoreCase(String name);
    Set<Topic> getAllByNameAllIgnoreCase(String[] names);
    boolean existsByNameAllIgnoreCase(String name);
}
