package io.github.vikie1.portfolio.articles;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Articles {
    
    @Id @Getter @Setter
    private String name;
    private String imgURL;
    private String description;
    private String url;

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    /**
     * @return the imgURL
     */
    public String getImgURL() {
        return imgURL;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
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
}
