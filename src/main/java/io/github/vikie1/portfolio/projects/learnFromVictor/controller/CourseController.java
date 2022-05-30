package io.github.vikie1.portfolio.projects.learnFromVictor.controller;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.course.CourseIdentifiers;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.dao.ApiData;
import io.github.vikie1.portfolio.projects.learnFromVictor.service.CourseService;
import io.github.vikie1.portfolio.projects.learnFromVictor.util.CourseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lfv")
public class CourseController {
    @Autowired
    private CourseService courseService;

    //GET
    @GetMapping("/courses")
    public Map<String, List<CourseIdentifiers>> getAllCourses() {
        Map<String, List<CourseIdentifiers>> courses = new HashMap<>();
        courses.put("courses", courseService.getAllCourses());
        return courses;
    }
    @GetMapping("/courses/{name}")
    public Map<String, CourseIdentifiers> getCourseByName(String name) {
        Map<String, CourseIdentifiers> courses = new HashMap<>();
        courses.put("courses", courseService.getByCourseName(name));
        return courses;
    }

    //POST
    @PostMapping("/courses")
    public void addCourse(@RequestBody ApiData.Course course) {
        courseService.addCourse(CourseUtil.retrieveCourse(course));
    }

    //PUT
    @PutMapping("/courses/{id}")
    public void updateCourse(@RequestBody ApiData.Course course, @PathVariable long id) {
        courseService.updateCourse(CourseUtil.retrieveCourse(course), id);
    }

    //DELETE
    @DeleteMapping("/courses/{id}")
    public void deleteCourseSection(@PathVariable long id) {
        courseService.deleteCourseSegment(id);
    }
    @DeleteMapping("/courses/full/{name}")
    public void deleteCourse(@PathVariable String name) {
        courseService.deleteFullCourse(name);
    }
}
