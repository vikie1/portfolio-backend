package io.github.vikie1.portfolio.projects.learnFromVictor.entity.course;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CourseIdentifiers {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;
    @Column(unique = true)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courseId", cascade = CascadeType.ALL)
    Set<Course> courses;

    public CourseIdentifiers() {}

    public CourseIdentifiers(String name) {
        setName(name);
    }

    public long getCourseId() { return courseId; }
    public String getName() { return name; }
    public Set<Course> getCourses() { return courses; }

    public void setCourseId(int courseId) { this.courseId = courseId; }
    public void setName(String name) { this.name = name; }
    public void setCourses(Set<Course> courses) { this.courses = courses; }
}
