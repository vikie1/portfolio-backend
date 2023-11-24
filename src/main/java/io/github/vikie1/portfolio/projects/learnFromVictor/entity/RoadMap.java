package io.github.vikie1.portfolio.projects.learnFromVictor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.Length;

import java.time.LocalDate;
import java.util.HashSet;
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
    @Column(length = Length.LOB_DEFAULT)
    private String explanation;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE) @JoinTable(joinColumns = @JoinColumn(name = "road_map_id"))
	private Set<Topic> topics = new HashSet<>();

    public RoadMap() {}

    public RoadMap(String name, String imgURL, String description, LocalDate postDate, String explanation, String[] topics) {
        setName(name);
        setDescription(description);
        setImgURL(imgURL);
		setPostDate(postDate);
        setTopics(topics);
        setExplanation(explanation);
    }


    //Just getters
    public Set<Topic> getTopics() { return topics; }
    public String getDescription() { return description; }
    public LocalDate getPostDate() { return postDate; }
    public String getImgURL() { return imgURL; }
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getExplanation() { return explanation; }

    //Just setters
    public void setId(Long id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setPostDate(LocalDate postDate) { this.postDate = postDate; }
    public void setImgURL(String imgURL) { this.imgURL = imgURL; }
    public void setName(String name) { this.name = name; }
    @JsonIgnore
    public void setTopic(Set<Topic> topics) { this.topics = topics; }
    public void setExplanation(String explanation) { this.explanation = explanation; }
    public void setTopics(String[] topics) {
        for (String topic : topics) {
            this.topics.add(new Topic(topic));
        }
    }
}
