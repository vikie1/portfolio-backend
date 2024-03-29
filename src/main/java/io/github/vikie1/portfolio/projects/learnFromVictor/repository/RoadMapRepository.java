package io.github.vikie1.portfolio.projects.learnFromVictor.repository;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.RoadMap;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface RoadMapRepository extends JpaRepository<RoadMap, Long> {
    RoadMap getByNameAllIgnoreCase(String name);
    List<RoadMap> getAllByTopicsIn(Set<Topic> topics);
    boolean existsByNameAllIgnoreCase(String name);
}
