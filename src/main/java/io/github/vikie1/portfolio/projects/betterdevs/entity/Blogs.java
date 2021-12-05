package io.github.vikie1.portfolio.projects.betterdevs.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Blogs {

    @Id @Column(name = "id", nullable = false) @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String imgURL;
    private String description;
    private String link;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE) @JoinColumn(name = "blogs_id")
    private Set<Topic> topic;

    public Blogs() {}
    public Blogs(String name, String imgURL, String description, String link){
        setName(name);
        setDescription(description);
        setImgURL(imgURL);
        setLink(link);
    }

    //Just getters
    public Set<Topic> getTopic() { return topic; }
    public String getDescription() { return description; }
    public String getLink() { return link; }
    public String getImgURL() { return imgURL; }
    public Long getId() { return id; }
    public String getName() { return name; }

    //Just setters
    public void setId(Long id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setLink(String link) { this.link = link; }
    public void setImgURL(String imgURL) { this.imgURL = imgURL; }
    public void setName(String name) { this.name = name; }
    public void setTopic(Set<Topic> topic) { this.topic = topic; }
}
