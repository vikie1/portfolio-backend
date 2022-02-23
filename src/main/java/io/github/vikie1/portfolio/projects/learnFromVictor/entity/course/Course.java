package io.github.vikie1.portfolio.projects.learnFromVictor.entity.course;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.Topic;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false)
    private Long id;
    private String description;
    private String imgURL;
    private LocalDate postDate;
    private double chapter;
    @Lob @Type(type = "org.hibernate.type.TextType")
    private String content;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE) @JoinColumn(name = "course_id")
    private Set<Topic> topic;
    @ManyToOne(optional = false) @JoinColumn(name = "course_id_course_id", nullable = false)
    private CourseIdentifiers courseId;

    public Course() {}

    public Course(String description, String imgURL, LocalDate postDate, double chapter, Set<Topic> topic, String content) {
        setChapter(chapter);
        setDescription(description);
        setImgURL(imgURL);
        setPostDate(postDate);
        setTopic(topic);
        setContent(content);
    }

    public CourseIdentifiers getCourseId() {
        return courseId;
    }
    public String getDescription() { return description; }
    public String getImgURL() { return imgURL; }
    public double getChapter() { return chapter; }
    public LocalDate getPostDate() { return postDate; }
    public Set<Topic> getTopic() { return topic; }
    public Long getId() { return id; }
    public String getContent() { return content; }

    public void setCourseId(CourseIdentifiers courseId) {
        this.courseId = courseId;
    }
    public void setId(Long id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setImgURL(String imgURL) { this.imgURL = imgURL; }
    public void setPostDate(LocalDate postDate) { this.postDate = postDate; }
    public void setChapter(double chapter) { this.chapter = chapter; }
    public void setTopic(Set<Topic> topic) { this.topic = topic; }
    public void setContent(String content) { this.content = content; }
}