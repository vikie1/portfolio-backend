package io.github.vikie1.portfolio.projects.learnFromVictor.service;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.Blogs;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.Topic;
import io.github.vikie1.portfolio.projects.learnFromVictor.error.DatabaseWriteError;
import io.github.vikie1.portfolio.projects.learnFromVictor.repository.BlogRepository;
import io.github.vikie1.portfolio.projects.learnFromVictor.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    //READ
    public List<Blogs> getAll(){
        return blogRepository.findAll();
    }
    public List<Blogs> getByTopics(String topics){
        String[] topicsList = topics.replaceAll("\\s*,\\s*", ",").split(",");
        return blogRepository.findAllByTopicIn(topicsRepository.findAllByNameIn(List.of(topicsList)));
    }
    public List<Blogs> getByPublished(boolean published){
        return blogRepository.findAllByPublished(published);
    }
    public Blogs getById(long id){
        return blogRepository.findById(id).orElse(null);
    }
    public BlogWithRelated getWithRelated(long id){
        Blogs blog = getById(id);
        List<Blogs> blogs = null;
        if (blog != null) blogs = getByTopics(blog.getTopic().stream().map(Topic::getName).collect(Collectors.joining(" ,")));
        return new BlogWithRelated(
            blog,
            blogs
        );
    }

    //UPDATE
    @Async
    public void update(Blogs blog){
        Set<Topic> current = blog.getTopic();
        Set<Topic> required = new HashSet<>();
        for (Topic topic: current) {
            if (!topicsRepository.existsByNameAllIgnoreCase(topic.getName())) { topicsRepository.save(topic); }
            required.add(topicsRepository.getByNameAllIgnoreCase(topic.getName()));
        }
        Blogs existing = blogRepository.findByNameAllIgnoreCase(blog.getName());
        blog.setTopic(required);
        blog.setId(existing.getId());
        blogRepository.save(blog);
    }

    //DELETE
    @Async
    public void delete(Blogs blog){ if (blogRepository.existsByNameAllIgnoreCase(blog.getName())) blogRepository.delete(blog);}
    @Async
    public void delete(long id){
        if (blogRepository.existsById(id)) blogRepository.deleteById(id);
    }

    public record BlogWithRelated(Blogs current, List<Blogs> related) {}
}
