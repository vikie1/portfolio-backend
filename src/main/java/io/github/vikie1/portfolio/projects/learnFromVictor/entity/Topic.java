package io.github.vikie1.portfolio.projects.learnFromVictor.entity;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.course.Course;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.course.CourseIdentifiers;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Topic {
    @Id @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToMany(mappedBy = "topic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Blogs> blogs;
    @ManyToMany(mappedBy = "topic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<CourseIdentifiers> courseIdentifiers;

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
