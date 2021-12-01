package io.github.vikie1.portfolio.articles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ArticlesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetArticles() throws Exception {
        this.mockMvc.perform(get("/api/blog"))
                .andExpect(status().isOk());
        this.mockMvc.perform(get("/blog"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetArticle() throws Exception {
        //the article is available
        this.mockMvc.perform(get("/api/blog/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json("{\"currArticle\":[" +
                        "{\"id\":1,\"name\":\"test\",\"imgURL\":\"test\",\"description\":\"test\",\"topic\":\"test\",\"fullArticle\":\"test\"}" +
                        "]," +
                        " \"blog\":[" +
                        "{\"id\":2,\"name\":\"test2\",\"imgURL\":\"test2\",\"description\":\"test2\",\"topic\":\"test\",\"fullArticle\":\"test2\"}]}"));
    }

    @Test
    public void testGetArticleNotFound() throws Exception {
        this.mockMvc.perform(get("/api/blog/100"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json("{\"currArticle\":[null], \"blog\":[]}")); //the json is null
    }
}