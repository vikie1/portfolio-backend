package io.github.vikie1.portfolio.articles;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/")
public class ArticlesController {
    
    @Autowired
    ArticleService articleService;

    @RequestMapping(value="/articles", method=RequestMethod.GET)
    public HashMap<String, List<Articles>> requestArticles() {
        HashMap<String, List<Articles>> articles = new HashMap<>();
        articles.put("articles", articleService.getArticles());
        return articles;
    }
    
    @PostMapping(value="/articles")
    public void postArticle(@RequestBody Articles entity) {
        articleService.addArticles(entity);
    }
    
    @DeleteMapping(value = "/articles/{param}")
    public void deleteArticle(@PathVariable String param) {
        articleService.deleteArticle(param);
    }
}
