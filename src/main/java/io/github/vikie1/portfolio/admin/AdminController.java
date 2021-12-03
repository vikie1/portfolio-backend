package io.github.vikie1.portfolio.admin;

import io.github.vikie1.portfolio.admin.user.UserEntity;
import io.github.vikie1.portfolio.admin.user.UserService;
import io.github.vikie1.portfolio.articles.ArticleService;
import io.github.vikie1.portfolio.articles.Articles;
import io.github.vikie1.portfolio.projects.ProjectService;
import io.github.vikie1.portfolio.projects.Projects;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@OpenAPIDefinition(tags = {
        @Tag(name = "Admin", description = "Admin operations")
})
public class AdminController {

    @Autowired UserService userService;
    @Autowired ArticleService articleService;
    @Autowired ProjectService projectService;

    //read operations
    @GetMapping(value = "")
    public String getAdminPanel() { return "admin"; }
    @GetMapping(value = "/signUp")  public String getSignup() { return "signup"; }
    @GetMapping(value = "/blog/new") public String getNewBlogCreator() { return "createblogs"; }
    @GetMapping(value = "/projects/new") public String getNewProjectCreator() { return "create_projects"; }
    @GetMapping(value = "/betterdevs") public String getBetterDevs() { return "betterdevs"; }

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
    public String postProject(Projects entity) {
        projectService.addProject(entity);
        return "redirect:/admin";
    }

    //delete operations will be in a RestController


}
