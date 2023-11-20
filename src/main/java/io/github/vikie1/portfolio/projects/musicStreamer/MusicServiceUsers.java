package io.github.vikie1.portfolio.projects.musicStreamer;

import jakarta.persistence.*;

@Entity
public class MusicServiceUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String username, password;

    public MusicServiceUsers() {
    }

    public MusicServiceUsers(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
