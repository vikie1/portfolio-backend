package io.github.vikie1.portfolio.projects.betterdevs.service;

import io.github.vikie1.portfolio.projects.betterdevs.entity.Blogs;
import io.github.vikie1.portfolio.projects.betterdevs.entity.Topic;
import io.github.vikie1.portfolio.projects.betterdevs.error.DatabaseWriteError;
import io.github.vikie1.portfolio.projects.betterdevs.repository.BlogRepository;
import io.github.vikie1.portfolio.projects.betterdevs.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service @EnableAsync
public class BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    TopicsRepository topicsRepository;

    //CREATE
    @Async
    public void save(Blogs blog){
        if (blogRepository.existsByNameAllIgnoreCase(blog.getName()))
            throw new DatabaseWriteError("A blog with the name '" + blog.getName() + "' exists, consider updating if change is needed");
        Set<Topic> current = blog.getTopic();
        Set<Topic> required = new HashSet<>();
        for (Topic topic: current) {
            if (!topicsRepository.existsByNameAllIgnoreCase(topic.getName())) {
                topicsRepository.save(topic);
            }
            required.add(topicsRepository.getByNameAllIgnoreCase(topic.getName()));
        }
        blog.setTopic(required);
        blogRepository.save(blog);
    }
}
