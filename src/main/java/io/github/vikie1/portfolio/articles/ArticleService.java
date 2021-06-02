package io.github.vikie1.portfolio.articles;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    
    @Autowired
    ArticlesRepo articlesRepo;

    public void addArticles(Articles articles) {
        articlesRepo.save(articles);
    }

    public List<Articles> getArticles() {
        List<Articles> articles = new ArrayList<>();
        articlesRepo.findAll().forEach(articles :: add);
        return articles;
    }

    public void deleteArticle(String id) {
        articlesRepo.deleteById(id);
    }
}
