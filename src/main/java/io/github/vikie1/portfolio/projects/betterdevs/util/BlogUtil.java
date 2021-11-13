package io.github.vikie1.portfolio.projects.betterdevs.util;

import io.github.vikie1.portfolio.projects.betterdevs.entity.Blogs;
import io.github.vikie1.portfolio.projects.betterdevs.entity.Topic;
import io.github.vikie1.portfolio.projects.betterdevs.entity.dao.ApiData;
import io.github.vikie1.portfolio.projects.betterdevs.error.InvalidDataError;

import java.util.HashSet;
import java.util.Set;

public class BlogUtil {

    public static Blogs retrieveBlog(ApiData.Blog rawBlog){
        if (rawBlog.name().isEmpty() || rawBlog.topics().length == 0)
            throw new InvalidDataError("Blog name and topics are missing");
        Set<Topic> topics = new HashSet<>();
        for (String topic: rawBlog.topics()) topics.add(new Topic(topic));
        Blogs blog = new Blogs(rawBlog.name(), rawBlog.imgURL(), rawBlog.description(), rawBlog.link());
        blog.setTopic(topics);
        return blog;
    }
}
