package io.github.vikie1.portfolio.projects.learnFromVictor.util;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.course.Course;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.Topic;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.course.CourseIdentifiers;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.dao.ApiData;
import io.github.vikie1.portfolio.projects.learnFromVictor.error.InvalidDataError;

import java.util.HashSet;
import java.util.Set;

public class CourseUtil {
    public static Course retrieveCourse(ApiData.Course rawCourse) {
        if (rawCourse.name().isEmpty()) throw new InvalidDataError("Blog name and topics are missing");
        Set<Topic> topics = new HashSet<>();
        for (String topic: rawCourse.topics()) topics.add(new Topic(topic));
        Course course =  new Course(
                rawCourse.description(),
                rawCourse.imgURL(),
                rawCourse.postDate(),
                rawCourse.chapter(), topics,
                rawCourse.content()
        );
        course.setCourseId(new CourseIdentifiers(rawCourse.name()));
        return course;
    }
}
