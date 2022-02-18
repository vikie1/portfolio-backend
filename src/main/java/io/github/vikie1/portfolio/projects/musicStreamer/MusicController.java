package io.github.vikie1.portfolio.projects.musicStreamer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/music")
public class MusicController {
    @Autowired
    MusicRepository musicRepository;
    @Autowired
    MusicUsersRepository musicUsersRepository;

    @GetMapping("/")
    public Iterable<MusicEntity> getAllMusic() {
        return musicRepository.findAll();
    }
    @PostMapping("/")
    public MusicEntity addMusic(@RequestBody MusicEntity musicEntity) {
        return musicRepository.save(musicEntity);
    }
    @PostMapping("/{id}/like")
	public MusicEntity likeMusic(@PathVariable("id") long id,@RequestBody boolean like) {
        MusicEntity musicEntity = musicRepository.findById(id).orElse(null);
        assert musicEntity != null;
        if (like) musicEntity.setLikes(musicEntity.getLikes() + 1);
        else musicEntity.setDislikes(musicEntity.getDislikes() + 1);
        return musicRepository.save(musicEntity);
    }

    @GetMapping("/user/{username}")
    public MusicServiceUsers getUser(@PathVariable("username") String username) {
        return musicUsersRepository.findByUsername(username).orElse(null);
    }
    @PostMapping("/user")
    public MusicServiceUsers addUser(@RequestBody MusicServiceUsers musicServiceUsers) {
        return musicUsersRepository.save(musicServiceUsers);
    }
}
