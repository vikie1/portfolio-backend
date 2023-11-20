package io.github.vikie1.portfolio.projects.learnFromVictor.repository;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicsRepository extends JpaRepository<Topic, Long> {
    Topic getByNameAllIgnoreCase(String name);
    List<Topic> findAllByNameInAllIgnoreCase(Iterable<String> names);
    boolean existsByNameAllIgnoreCase(String name);
}
