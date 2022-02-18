package io.github.vikie1.portfolio.projects.musicStreamer;

import org.springframework.scheduling.annotation.EnableAsync;

import javax.persistence.*;

@Entity
public class MusicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name, artist,musicUrl;
    private long likes,dislikes;
    public MusicEntity(){}
    public MusicEntity(String name, String artist, String musicUrl) {
        setMusicUrl(musicUrl);
        setArtist(artist);
        setName(name);
        this.likes=0;
        this.dislikes=0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public void setDislikes(long dislikes) {
        this.dislikes = dislikes;
    }

    public long getDislikes() {
        return dislikes;
    }
}
