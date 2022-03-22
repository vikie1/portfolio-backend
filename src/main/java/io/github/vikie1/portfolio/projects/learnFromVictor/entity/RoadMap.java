package io.github.vikie1.portfolio.projects.learnFromVictor.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class RoadMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String imgURL;
    private String description;
    private LocalDate postDate;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE) @JoinColumn(name = "road_map_id")
    private Set<Topic> topics;

    public RoadMap() {}

    public RoadMap(String name, String imgURL, String description, LocalDate postDate, String[] topics) {
        setName(name);
        setDescription(description);
        setImgURL(imgURL);
        setLocalDate(postDate);
        setTopics(topics);
    }


    //Just getters
    public Set<Topic> getTopics() { return topics; }
    public String getDescription() { return description; }
    public LocalDate getPostDate() { return postDate; }
    public String getImgURL() { return imgURL; }
    public Long getId() { return id; }
    public String getName() { return name; }

    //Just setters
    public void setId(Long id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setLocalDate(LocalDate localDate) { this.postDate = localDate; }
    public void setImgURL(String imgURL) { this.imgURL = imgURL; }
    public void setName(String name) { this.name = name; }
    public void setTopics(Set<Topic> topics) { this.topics = topics; }
    public void setTopics(String[] topics) {
        for (String topic : topics) {
            this.topics.add(new Topic(topic));
        }
    }
}
