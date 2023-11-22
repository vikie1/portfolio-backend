package io.github.vikie1.portfolio.projects.learnFromVictor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.course.CourseIdentifiers;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Topic {
    @Id @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToMany(mappedBy = "topic", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    Set<Blogs> blogs;
    @ManyToMany(mappedBy = "topic", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    Set<CourseIdentifiers> courseIdentifiers;
    @ManyToMany(mappedBy = "topics", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    Set<RoadMap> roadMaps;

    @JsonIgnore
    public Set<RoadMap> getRoadMaps() {
        return roadMaps;
    }

    @JsonIgnore
    public Set<CourseIdentifiers> getCourseIdentifiers() {
        return courseIdentifiers;
    }

    @JsonIgnore
    public Set<Blogs> getBlogs() {
        return blogs;
    }

    public Topic(String name){
        setName(name);
    }
    public Topic(){}

    //Just a couple of getters
    public Long getId() { return id; }
    public String getName() { return name; }

    //Just a couple of setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}
