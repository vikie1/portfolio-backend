package io.github.vikie1.portfolio.projects.musicStreamer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicController {
    @GetMapping("/burng")
    public String getTemplate() { return "burng"; }
}
