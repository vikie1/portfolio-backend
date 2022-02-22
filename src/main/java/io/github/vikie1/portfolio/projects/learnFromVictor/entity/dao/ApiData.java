package io.github.vikie1.portfolio.projects.learnFromVictor.entity.dao;

import java.time.LocalDate;

public class ApiData{
    public static record Blog(
          String name,
          String imgURL,
          String description,
          LocalDate publishDate,
          String[] topics
    ){}
}
