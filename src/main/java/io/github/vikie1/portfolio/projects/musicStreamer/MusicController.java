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
    public Iterable<MusicEntity> getAllMusic() { return musicRepository.findAll(); }

    @PostMapping("/")
    public MusicEntity addMusic(@RequestBody MusicEntity musicEntity) {
        return musicRepository.save(musicEntity);
    }
}
