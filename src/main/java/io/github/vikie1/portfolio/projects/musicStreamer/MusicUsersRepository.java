package io.github.vikie1.portfolio.projects.musicStreamer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicUsersRepository extends JpaRepository<MusicServiceUsers, Long> {
    Optional<MusicServiceUsers> findByUsername(String username);
}
