package io.github.vikie1.portfolio.projects.learnFromVictor.util;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.Blogs;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.Topic;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.dao.ApiData;
import io.github.vikie1.portfolio.projects.learnFromVictor.error.InvalidDataError;

import java.util.HashSet;
import java.util.Set;

public class BlogUtil {

    public static Blogs retrieveBlog(ApiData.Blog rawBlog){
        if (rawBlog.name().isEmpty() || rawBlog.topics().length == 0)
            throw new InvalidDataError("Blog name and topics are missing");
        Set<Topic> topics = new HashSet<>();
        for (String topic: rawBlog.topics()) topics.add(new Topic(topic));
        Blogs blog = new Blogs(rawBlog.name(), rawBlog.imgURL(), rawBlog.description(), rawBlog.publishDate());
        blog.setTopic(topics);
        return blog;
    }
}
