package io.github.vikie1.portfolio.articles.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired TopicRepository topicRepository;

    public void addTopic(String topic){ if (!topicRepository.existsByTopic(topic)) topicRepository.save(new TopicEntity(topic)); }

    public List<TopicEntity> getTopics(){return new ArrayList<>( topicRepository.findAll()); }
}
