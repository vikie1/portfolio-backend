package io.github.vikie1.portfolio.projects.learnFromVictor.service;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.RoadMap;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.Topic;
import io.github.vikie1.portfolio.projects.learnFromVictor.error.DatabaseWriteError;
import io.github.vikie1.portfolio.projects.learnFromVictor.repository.RoadMapRepository;
import io.github.vikie1.portfolio.projects.learnFromVictor.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service @EnableAsync
public class RoadMapService {
    @Autowired private RoadMapRepository roadMapRepository;
    @Autowired TopicsRepository topicsRepository;

    //CREATE
    @Async
    public void add(RoadMap roadMap){
        if (roadMapRepository.existsByNameAllIgnoreCase(roadMap.getName()))
            throw new DatabaseWriteError("RoadMap with name: " + roadMap.getName() + " already exists, consider an update instead");
        Set<Topic> topics = new HashSet<>();
        for (Topic topic: roadMap.getTopics()) {
            if (!topicsRepository.existsByNameAllIgnoreCase(topic.getName())) topics.add(topicsRepository.save(topic));
            else topics.add(topicsRepository.getByNameAllIgnoreCase(topic.getName()));
        }
        roadMap.setTopics(topics);
        roadMapRepository.save(roadMap);
    }
}
