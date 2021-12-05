package io.github.vikie1.portfolio.articles;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ArticlesController {
    
    @Autowired
    ArticleService articleService;

    @RequestMapping(value="/blog", method=RequestMethod.GET)
    @Operation(summary = "will return all the present articles")
    public HashMap<String, List<Articles>> requestArticles() {
        HashMap<String, List<Articles>> articles = new HashMap<>();
        articles.put("blog", articleService.getArticles());
        return articles;
    }
    
    @GetMapping(value="/blog/{id}")
    public HashMap<String, List<Articles>> getArticle(@Parameter(description = "The numerical(Long) id of the article") @PathVariable int id) {
        HashMap<String, List<Articles>> serveBlog = new HashMap<>();
        serveBlog.put("currArticle", articleService.getSingleArticle(id));
        serveBlog.put("blog", articleService.getRelatedArticles(id));
        return serveBlog;
    }
}
