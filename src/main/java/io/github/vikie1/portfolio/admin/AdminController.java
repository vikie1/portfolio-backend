package io.github.vikie1.portfolio.admin;

import io.github.vikie1.portfolio.admin.user.UserEntity;
import io.github.vikie1.portfolio.admin.user.UserService;
import io.github.vikie1.portfolio.articles.ArticleService;
import io.github.vikie1.portfolio.articles.Articles;
import io.github.vikie1.portfolio.projects.ProjectService;
import io.github.vikie1.portfolio.projects.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired UserService userService;
    @Autowired ArticleService articleService;
    @Autowired ProjectService projectService;

    //read operations
    @GetMapping(value = "") public String getAdminPanel() { return "admin"; }

    @GetMapping(value = "/signUp") public String getSignup() { return "signup"; }
    @GetMapping(value = "/blog/new") public String getNewBlogCreator() { return "createblogs"; }
    @GetMapping(value = "/projects/new") public String getNewProjectCreator() { return "create_projects"; }

    // create operations updates will stay here for the time being.
    @PostMapping(value = "/signUp")
    public String postSignup(UserEntity entity) {
        userService.signUp(entity);
        return "redirect:/admin";
    }
    @PostMapping(value = "/blog/new")
    public String postNewBlog(Articles entity) {
        articleService.addArticles(entity);
        return "redirect:/admin";
    }
    @PostMapping(value="/projects/new")
    public String postProject(@RequestBody Projects entity) {
        projectService.addProject(entity);
        return "redirect:/admin";
    }
    @PostMapping(value="/blog")
    public void postArticle(@RequestBody Articles entity) {
        articleService.addArticles(entity);
    }



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
