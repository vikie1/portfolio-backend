package io.github.vikie1.portfolio.articles;

import jakarta.persistence.*;
import org.hibernate.Length;

@Entity
public class Articles {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String imgURL;
    private String description;
    private String topic;
    @Column(length = Length.LOB_DEFAULT)
    private String fullArticle;

    /**
     * @return the imgURL
     */
    public String getImgURL() {
        return imgURL;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @param imgURL the imgURL to set
     */
    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    /**
     * @return the fullArticle
     */
    public String getFullArticle() {
        return fullArticle;
    }
    /**
     * @param fullArticle the fullArticle to set
     */
    public void setFullArticle(String fullArticle) {
        this.fullArticle = fullArticle;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the topic
     */
    public String getTopic() {
        return topic;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param topic the topic to set
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return """
            {
                name: %s,
                id: %d,
                imgURL: %s,
                description: %s,
                topic: %s,
                fullArticle: %s
            }
        """.formatted(name, id, imgURL, description, topic, fullArticle);
    }
}
