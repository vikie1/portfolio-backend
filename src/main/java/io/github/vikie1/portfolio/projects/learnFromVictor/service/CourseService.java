package io.github.vikie1.portfolio.projects.learnFromVictor.service;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.Topic;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.course.Course;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.course.CourseIdentifiers;
import io.github.vikie1.portfolio.projects.learnFromVictor.error.InvalidDataError;
import io.github.vikie1.portfolio.projects.learnFromVictor.repository.CourseIdRepository;
import io.github.vikie1.portfolio.projects.learnFromVictor.repository.CourseRepository;
import io.github.vikie1.portfolio.projects.learnFromVictor.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@EnableAsync
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TopicsRepository topicsRepository;
    @Autowired
    CourseIdRepository courseIdRepository;

    //CREATE
    @Async
    public void addCourse(Course course) {
        if (course == null || course.getCourseId().getName().isEmpty()) throw new IllegalArgumentException("Course name cannot be null");
        Set<Topic> topics = course.getCourseId().getTopic();
        Set<Topic> topicsToSave = new HashSet<>();
        for (Topic topic : topics) {
            if(!topicsRepository.existsByNameAllIgnoreCase(topic.getName())) {
                topicsToSave.add(topicsRepository.save(topic));
            }else topicsToSave.add(topicsRepository.getByNameAllIgnoreCase(topic.getName()));
        }
        course.getCourseId().setTopic(topicsToSave);
        if (courseIdRepository.existsByNameAllIgnoreCase(course.getCourseId().getName())){
            CourseIdentifiers courseIdentifiers = courseIdRepository.findByNameAllIgnoreCase(course.getCourseId().getName());
            courseIdentifiers.setTopic(topicsToSave);
            course.setCourseId(courseIdRepository.save(courseIdentifiers));
        }
        else course.setCourseId(courseIdRepository.save(course.getCourseId()));
        courseRepository.save(course);
    }

    //READ
    public List<CourseIdentifiers> getAllCourses(){ return courseIdRepository.findAll(); }
    public CourseIdentifiers getByCourseName(String name){
        return courseIdRepository.findByNameAllIgnoreCase(name);
    }

    //UPDATE
    @Async
    public void updateCourse(Course course, long id){
        if (course == null || course.getCourseId().getName().isEmpty())
            throw new IllegalArgumentException("Course name cannot be null");
        if (!courseIdRepository.existsByNameAllIgnoreCase(course.getCourseId().getName()))
            throw new InvalidDataError("Course does not exist, create before update");
        Set<Topic> topics = course.getCourseId().getTopic();
        Set<Topic> topicsToSave = new HashSet<>();
        for (Topic topic : topics) {
            if(!topicsRepository.existsByNameAllIgnoreCase(topic.getName())) topicsRepository.save(topic);
            topicsToSave.add(topicsRepository.getByNameAllIgnoreCase(topic.getName()));
        }
        course.setId(id);
        course.setCourseId(courseIdRepository.findByNameAllIgnoreCase(course.getCourseId().getName()));
        course.getCourseId().setTopic(topicsToSave);
        course.setCourseId(courseIdRepository.save(course.getCourseId()));
        courseRepository.save(course);
    }

    //DELETE
    @Async
    public void deleteCourseSegment(long id){
        courseRepository.deleteById(id);
    }
    @Async
    public void deleteFullCourse(String name){
        courseRepository.deleteAllByCourseId(courseIdRepository.findByNameAllIgnoreCase(name));
        courseIdRepository.deleteByNameAllIgnoreCase(name);
    }
}
