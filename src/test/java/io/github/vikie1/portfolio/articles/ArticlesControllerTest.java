package io.github.vikie1.portfolio.articles;

import io.github.vikie1.portfolio.admin.AdminController;
import io.github.vikie1.portfolio.articles.topics.TopicEntity;
import io.github.vikie1.portfolio.articles.topics.TopicRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ArticlesControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ArticlesRepo articlesRepo;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticlesController articlesController;
    @Autowired
    private AdminController adminController;
    @MockBean
    private TopicRepository topicRepository;

    @Test
    void articleCreationWorks() throws Exception {
        Articles articles = new Articles();
        articles.setName("Test");
        articles.setDescription("Test");
        articles.setTopic("Java");
        articles.setId(1);
        given(articlesRepo.save(any(Articles.class))).willReturn(new Articles());
        given(topicRepository.save(any(TopicEntity.class))).willReturn(new TopicEntity());
        given(articlesRepo.findById(1L)).willReturn(java.util.Optional.of(articles));
        adminController.postNewBlog(articles);
        assertThat(articlesController.getArticle(1).get("currArticle").get(0).getName()).isEqualTo("Test");
    }

    @Test
    public void testGetArticles() throws Exception {
        this.mockMvc.perform(get("/api/blog"))
                .andExpect(status().isOk());
        this.mockMvc.perform(get("/blog"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetArticle() throws Exception {
        given(articlesRepo.findById(1L)).willReturn(java.util.Optional.of(new Articles()));
        //the article is available
        this.mockMvc.perform(get("/api/blog/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json("{\"currArticle\":[{}]," +
                        " \"blog\":[]}"));
    }

    @Test
    public void testGetArticleNotFound() throws Exception {
        this.mockMvc.perform(get("/api/blog/100"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json("{\"currArticle\":[null], \"blog\":[]}")); //the json is null
    }
}