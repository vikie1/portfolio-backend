package io.github.vikie1.portfolio.projects.learnFromVictor.repository;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.Blogs;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface BlogRepository extends JpaRepository<Blogs, Long> {
    List<Blogs> findAllByTopicIn(Set<Topic> topics);
    List<Blogs> findAllByPublished(boolean published);
    Blogs findByNameAllIgnoreCase(String name);
    boolean existsByNameAllIgnoreCase(String name);
}
