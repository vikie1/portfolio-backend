package io.github.vikie1.portfolio.admin;

import io.github.vikie1.portfolio.admin.user.UserService;
import io.github.vikie1.portfolio.articles.ArticleService;
import io.github.vikie1.portfolio.projects.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminDeleteController {
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;
    @Autowired
    ProjectService projectService;

    //delete operations
    @DeleteMapping(value = "/projects") public void clearProjects(){ projectService.clear();}

    @DeleteMapping(value = "/user/{username}")
    public void deleteUser(@PathVariable String username){ userService.deleteUser(username); }

    @DeleteMapping(value = "/projects/delete/{id}")
    public void deleteProject(@PathVariable long id) {
        projectService.deleteProject(id);
    }

    @DeleteMapping(value = "/blog/{param}")
    public void deleteArticle(@PathVariable long param) {
        articleService.deleteArticle(param);
    }

}
