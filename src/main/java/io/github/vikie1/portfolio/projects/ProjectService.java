package io.github.vikie1.portfolio.projects;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    
    @Autowired
    ProjectRepo projectRepo;

    public List<Projects> getProjects() {
        List<Projects> projects = new ArrayList<>();
        projectRepo.findAll().forEach(projects :: add);
        return projects;
    }

    public void addProject(Projects projects) {
        projectRepo.save(projects);
    }

    public void deleteProject(long id) {
        projectRepo.deleteById(id);
    }

    public void clear(){
        projectRepo.deleteAll();
    }
}
