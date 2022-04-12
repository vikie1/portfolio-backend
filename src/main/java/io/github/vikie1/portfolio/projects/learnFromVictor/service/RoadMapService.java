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
import java.util.List;
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
        roadMap.setTopic(topics);
        roadMapRepository.save(roadMap);
    }

    //READ
    public List<RoadMap> getAll(){ return roadMapRepository.findAll(); }
    public RoadMap getByName(String name){ return roadMapRepository.getByNameAllIgnoreCase(name); }

    //UPDATE
    @Async
    public void update(RoadMap roadMap, long id){
        if (!roadMapRepository.existsByNameAllIgnoreCase(roadMap.getName()))
            throw new DatabaseWriteError("RoadMap with name: " + roadMap.getName() + " does not exist, consider an add instead");
        Set<Topic> topics = new HashSet<>();
        for (Topic topic: roadMap.getTopics()) {
            if (!topicsRepository.existsByNameAllIgnoreCase(topic.getName())) topics.add(topicsRepository.save(topic));
            else topics.add(topicsRepository.getByNameAllIgnoreCase(topic.getName()));
        }
        roadMap.setId(id);
        roadMap.setTopic(topics);
        roadMapRepository.save(roadMap);
    }

    //DELETE
    @Async
    public void delete(RoadMap roadMap){
        if (!roadMapRepository.existsByNameAllIgnoreCase(roadMap.getName()))
            throw new DatabaseWriteError("Cannot delete RoadMap with name: " + roadMap.getName() + " as it does not exist");
        roadMapRepository.delete(roadMap);
    }
    @Async
    public void delete(long id){
        if (!roadMapRepository.existsById(id))
            throw new DatabaseWriteError("Cannot delete RoadMap with id: " + id + " as it does not exist");
        roadMapRepository.deleteById(id);
    }
}
