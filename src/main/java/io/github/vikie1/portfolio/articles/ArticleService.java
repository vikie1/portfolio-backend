package io.github.vikie1.portfolio.articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        articlesRepo.findAll().forEach(articles::add);
        return articles;
    }

    public List<Articles> getSingleArticle(int name) {
        List<Articles> articles = new ArrayList<>();
        articles.add(articlesRepo.findById(name).orElse(null));
        return articles;
    }
    public void deleteArticle(int id) {
        articlesRepo.deleteById(id);
    }

    public List<Articles> getRelatedArticles(int id){
        List<Articles> relatedArticles = new ArrayList<>();
        Optional<Articles> currArticleObject = articlesRepo.findById(id);
        if(currArticleObject != null){
            relatedArticles.add(articlesRepo.findByTopic(currArticleObject.get().getTopic()).orElse(null));
        }
        return relatedArticles;
    }
}
