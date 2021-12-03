package io.github.vikie1.portfolio.articles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import io.github.vikie1.portfolio.articles.topics.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    ArticlesRepo articlesRepo;
    @Autowired
    TopicService topicService;

    public void addArticles(Articles articles) {
        articlesRepo.save(articles);
        topicService.addTopic(articles.getTopic());
    }

    public List<Articles> getArticles() { return new ArrayList<Articles>( articlesRepo.findAll() ); }

    public List<Articles> getSingleArticle(long id) {
        List<Articles> articles = new ArrayList<>();
        articles.add(articlesRepo.findById(id).orElse(null));
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
