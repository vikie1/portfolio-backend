package io.github.vikie1.portfolio.projects.learnFromVictor.repository;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.course.Course;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.course.CourseIdentifiers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    void deleteAllByCourseId(CourseIdentifiers courseIdentifiers);
}
