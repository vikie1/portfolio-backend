package io.github.vikie1.portfolio.projects.learnFromVictor.repository;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.course.CourseIdentifiers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseIdRepository extends JpaRepository<CourseIdentifiers, Long> {
    CourseIdentifiers findByNameAllIgnoreCase(String name);
    List<CourseIdentifiers> findByNameContainingAllIgnoreCase(String name);
    CourseIdentifiers findByCourseId(int courseId);
    boolean existsByNameAllIgnoreCase(String name);
    boolean existsByCourseId(int courseId);
    void deleteByNameAllIgnoreCase(String name);
}
