package io.github.vikie1.portfolio.projects.learnFromVictor.entity.course;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CourseIdentifiers {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;
    @Column(unique = true)
    private String name;
    private String description;
    private String imgURL;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courseId", cascade = CascadeType.ALL)
    Set<Course> courses;

    public CourseIdentifiers() {}

    public CourseIdentifiers(String description,String imgURL,  String name) {
        setName(name);
        setDescription(description);
        setImgURL(imgURL);
    }

    public long getCourseId() { return courseId; }
    public String getName() { return name; }
    public Set<Course> getCourses() { return courses; }
    public String getDescription() { return description; }
    public String getImgURL() { return imgURL; }

    public void setCourseId(int courseId) { this.courseId = courseId; }
    public void setName(String name) { this.name = name; }
    public void setCourses(Set<Course> courses) { this.courses = courses; }
    public void setDescription(String description) { this.description = description; }
    public void setImgURL(String imgURL) { this.imgURL = imgURL; }
}
