package io.github.vikie1.portfolio.projects.betterdevs.entity.dao;

import io.github.vikie1.portfolio.projects.betterdevs.entity.Blogs;
import io.github.vikie1.portfolio.projects.betterdevs.entity.Topic;

public class ApiData{
    public static record Blog(
          String name,
          String imgURL,
          String description,
          String link,
          String[] topics
    ){}
}
