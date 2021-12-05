package io.github.vikie1.portfolio.articles.topics;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<TopicEntity, Long> {
    boolean existsByTopic(String topic);
}
