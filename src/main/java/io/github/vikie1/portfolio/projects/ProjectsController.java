package io.github.vikie1.portfolio.projects;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProjectsController {
    @Autowired ProjectService projectService;

    @RequestMapping(value="/projects", method=RequestMethod.GET)
    public HashMap<String, List<Projects>> getProjects() {
        HashMap<String, List<Projects>> projects = new HashMap<>();
        projects.put("projects", projectService.getProjects());
        return projects;
    }
}
