package io.github.vikie1.portfolio.projects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Projects {
    

    public Projects(String name, String imgUrl, String title, String description, String url){
        this.description = description;
        this.name = name;
        this.imgUrl = imgUrl;
        this.title = title;
        this.url = url;
    }

    public Projects() {}

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String imgUrl;
    private String title;
    private String description;
    private String url;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }


    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @return the imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param imgUrl the imgUrl to set
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
