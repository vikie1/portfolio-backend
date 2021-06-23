package io.github.vikie1.portfolio.articles;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin(origins = "https://victormwangi.netlify.app")
@RequestMapping("/api")
public class ArticlesController {
    
    @Autowired
    ArticleService articleService;

    @RequestMapping(value="/blog", method=RequestMethod.GET)
    public HashMap<String, List<Articles>> requestArticles() {
        HashMap<String, List<Articles>> articles = new HashMap<>();
        articles.put("blog", articleService.getArticles());
        return articles;
    }
    
    @GetMapping(value="/blog/{id}")
    public List<Articles> getMethodName(@PathVariable int id) {
        List<Articles> articles = articleService.getSingleArticle(id);
        return articles;
    }
    
    @PostMapping(value="/blog")
    public void postArticle(@RequestBody Articles entity) {
        articleService.addArticles(entity);
    }
    
    @DeleteMapping(value = "/blog/{param}")
    public void deleteArticle(@PathVariable int param) {
        articleService.deleteArticle(param);
    }
}
