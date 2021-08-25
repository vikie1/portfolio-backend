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

    public List<Articles> getSingleArticle(long name) {
        List<Articles> articles = new ArrayList<>();
        articles.add(articlesRepo.findById(name).orElse(null));
        return articles;
    }
    public void deleteArticle(long id) {
        articlesRepo.deleteById(id);
    }

    public List<Articles> getRelatedArticles(long id){

        List<Articles> relatedArticles = new ArrayList<>();

        List<Articles> tempList = new ArrayList<>();
        Optional<Articles> currArticleObject = articlesRepo.findById(id);
        if (currArticleObject.isPresent()){
            String topic = currArticleObject.get().getTopic();
            tempList = articlesRepo.findAllByTopic(topic);
        }

        for (Articles articles : tempList) {
            if(articles.getId() != id) relatedArticles.add(articles);
        }
        
        return relatedArticles;
    }
}
