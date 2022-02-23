package io.github.vikie1.portfolio.projects.learnFromVictor.entity;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.course.Course;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Topic {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToMany(mappedBy = "topic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Blogs> blogs;
    @ManyToMany(mappedBy = "topic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Course> courses;

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