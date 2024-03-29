package io.github.vikie1.portfolio.articles.topics;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TopicEntity {

    @Id @Column(name = "id", nullable = false)
    private Long id;
    private String topic;

    public TopicEntity(){}

    public TopicEntity(String topic) { this.topic = topic; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() { return topic; }

    public void setTopic(String topic) { this.topic = topic; }
}
