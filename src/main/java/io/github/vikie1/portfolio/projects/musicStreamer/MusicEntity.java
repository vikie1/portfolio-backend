package io.github.vikie1.portfolio.projects.musicStreamer;

import javax.persistence.*;

@Entity
public class MusicEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name, artist, musicUrl;
    public MusicEntity(){}
    public MusicEntity(String name, String artist, String musicUrl) {
        setMusicUrl(musicUrl);
        setArtist(artist);
        setName(name);
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
}
