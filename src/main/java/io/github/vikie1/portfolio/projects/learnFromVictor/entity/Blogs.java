package io.github.vikie1.portfolio.projects.learnFromVictor.entity;

import jakarta.persistence.*;
import org.hibernate.Length;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Blogs {
    @Id @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String imgURL;
    private String description;
    private LocalDate postDate;
    private boolean published;
    @Column(length = Length.LOB_DEFAULT)
    private String post;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE) @JoinTable(joinColumns = @JoinColumn(name = "blogs_id"))
    private Set<Topic> topic;

    public Blogs() {}
    public Blogs(String name, String imgURL, String description, LocalDate date, String post){
        setName(name);
        setDescription(description);
        setImgURL(imgURL);
        setLocalDate(date);
        setPost(post);
    }

    public Set<Topic> getTopic() { return topic; }
    public String getDescription() { return description; }
    public LocalDate getPostDate() { return postDate; }
    public String getImgURL() { return imgURL; }
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getPost() { return post; }
    public boolean isPublished() { return published; }

    public void setId(Long id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setLocalDate(LocalDate localDate) { this.postDate = localDate; }
    public void setImgURL(String imgURL) { this.imgURL = imgURL; }
    public void setName(String name) { this.name = name; }
    public void setTopic(Set<Topic> topic) { this.topic = topic; }
    public void setPost(String post) { this.post = post; }

    public void setPublished(boolean published) { this.published = published; }
}
