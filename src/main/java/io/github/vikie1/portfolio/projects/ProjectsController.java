package io.github.vikie1.portfolio.projects;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "https://victormwangi.netlify.app")
@RequestMapping("/api")
public class ProjectsController {
    
    @Autowired
    ProjectService projectService;

    @RequestMapping(value="/projects", method=RequestMethod.GET)
    public HashMap<String, List<Projects>> getProjects() {
        HashMap<String, List<Projects>> projects = new HashMap<>();
        projects.put("projects", projectService.getProjects());
        return projects;
    }

    @PostMapping(value="/projects")
    public void postProject(@RequestBody Projects entity) {
        projectService.addProject(entity);
    }
    
    @DeleteMapping(value = "/projects/{id}")
    public void deleteProject(@PathVariable String id) {
        projectService.deleteProject(id);
    }

    @DeleteMapping(value = "/projects")
    public void deleteProject(){
        projectService.clear();
    }
}
