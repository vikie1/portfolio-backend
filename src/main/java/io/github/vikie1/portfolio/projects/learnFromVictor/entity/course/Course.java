package io.github.vikie1.portfolio.projects.learnFromVictor.entity.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private LocalDate postDate;
    private double chapter;
    @Lob
    private String content;
    @ManyToOne(optional = false) @JoinColumn(name = "course_id_course_id", nullable = false)
    private CourseIdentifiers courseId;

    public Course() {}

    public Course(LocalDate postDate, double chapter, String content, String name) {
        setChapter(chapter);
        setPostDate(postDate);
        setContent(content);
        setName(name);
    }

    @JsonIgnore
    public CourseIdentifiers getCourseId() { return courseId; }
    public String getName() {return name; }
    public double getChapter() { return chapter; }
    public LocalDate getPostDate() { return postDate; }
    public Long getId() { return id; }
    public String getContent() { return content; }

    public void setCourseId(CourseIdentifiers courseId) { this.courseId = courseId; }
    public void setId(Long id) { this.id = id; }
    public void setPostDate(LocalDate postDate) { this.postDate = postDate; }
    public void setChapter(double chapter) { this.chapter = chapter; }
    public void setContent(String content) { this.content = content; }
    public void setName(String name) { this.name = name; }
}
