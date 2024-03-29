package io.github.vikie1.portfolio.admin;

import io.github.vikie1.portfolio.auth.role.RoleEntity;
import io.github.vikie1.portfolio.auth.user.UserEntity;
import io.github.vikie1.portfolio.auth.user.UserService;
import io.github.vikie1.portfolio.articles.ArticleService;
import io.github.vikie1.portfolio.articles.Articles;
import io.github.vikie1.portfolio.projects.ProjectService;
import io.github.vikie1.portfolio.projects.Projects;
import io.github.vikie1.portfolio.projects.learnFromVictor.service.BlogService;
import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired UserService userService;
    @Autowired ArticleService articleService;
    @Autowired ProjectService projectService;
    @Autowired BlogService blogService;

    //read operations
    @GetMapping(value = "")
    public String getAdminPanel() { return "admin"; }
    @GetMapping(value = "/signUp")  public String getSignup() { return "signup"; }
    @GetMapping(value = "/projects/new") public String getNewProjectCreator() { return "create_projects"; }
    @GetMapping(value = "/betterdevs") public String getBetterDevs() { return "betterdevs"; }
    @GetMapping("/blog/edit") 
    public String getBlogEditor(Model model, @PathParam("id") long id) {
        if(id > 0) model.addAttribute("blog", blogService.getById(id));
        return "createblogs";
    }

    // create operations updates will stay here for the time being.
    @PostMapping(value = "/signUp")
    public String postSignup(UserEntity entity) {
        RoleEntity role = new RoleEntity();
        role.setName("ROLE_ADMIN");
        entity.addRole(role);
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
