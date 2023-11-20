package io.github.vikie1.portfolio.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.vikie1.portfolio.auth.user.UserEntity;
import io.github.vikie1.portfolio.auth.user.UserService;
import io.github.vikie1.portfolio.articles.ArticleService;
import io.github.vikie1.portfolio.articles.Articles;
import io.github.vikie1.portfolio.projects.ProjectService;
import io.github.vikie1.portfolio.projects.Projects;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "admin",password = "pass", roles = {"ADMIN"})
class AdminControllerTestAdmin {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private UserService userService;
    @MockBean
    private ArticleService articleService;
    @MockBean
    private ProjectService projectService;

    @Test
    void testForGetRequests() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/admin/signUp"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/admin/blog/new"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/admin/projects/new"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/admin/betterdevs"))
                .andExpect(status().isOk());
    }

    @Test
    void TestForPostRequests() throws Exception {
        doNothing().when(userService).signUp(any(UserEntity.class));
        doNothing().when(projectService).addProject(any(Projects.class));
        doNothing().when(articleService).addArticles(any(Articles.class));
        mockMvc.perform(post("/admin/signUp").with(csrf()))
                .andExpect(redirectedUrl("/admin"));
        mockMvc.perform(post("/admin/blog/new").with(csrf()))
                .andExpect(redirectedUrl("/admin"));
        mockMvc.perform(post("/admin/projects/new").with(csrf()))
                .andExpect(redirectedUrl("/admin"));
    }

    @Test
    void testForDeleteRequests() throws Exception {
        doNothing().when(userService).deleteUser(any(String.class));
        doNothing().when(projectService).deleteProject(any(Long.class));
        doNothing().when(articleService).deleteArticle(any(Long.class));
        mockMvc.perform(delete("/admin/user/{username}","name").with(csrf()))
                .andExpect(status().isOk());
        mockMvc.perform(delete("/admin/projects").with(csrf()))
                .andExpect(status().isOk());
        mockMvc.perform(delete("/admin/blog/{id}",1).with(csrf()))
                .andExpect(status().isOk());
        mockMvc.perform(delete("/admin/projects/delete/{id}",1).with(csrf()))
                .andExpect(status().isOk());
    }


}
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "user", password = "pass", roles = {"USER"})
class AdminControllerTestUsers {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private UserService userService;
    @MockBean
    private ArticleService articleService;
    @MockBean
    private ProjectService projectService;


    @Test
    void testForGetRequests() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isForbidden());
        mockMvc.perform(get("/admin/signUp"))
                .andExpect(status().isForbidden());
        mockMvc.perform(get("/admin/blog/new"))
                .andExpect(status().isForbidden());
        mockMvc.perform(get("/admin/projects/new"))
                .andExpect(status().isForbidden());
        mockMvc.perform(get("/admin/betterdevs"))
                .andExpect(status().isForbidden());
    }

    @Test
    void testForPostRequests() throws Exception {
        doNothing().when(userService).signUp(any(UserEntity.class));
        doNothing().when(projectService).addProject(any(Projects.class));
        doNothing().when(articleService).addArticles(any(Articles.class));
        mockMvc.perform(post("/admin/signUp").with(csrf()))
                .andExpect(status().isForbidden());
        mockMvc.perform(post("/admin/blog/new").with(csrf()))
                .andExpect(status().isForbidden());
        mockMvc.perform(post("/admin/projects/new").with(csrf()))
                .andExpect(status().isForbidden());
    }

    @Test
    void testForDeleteRequests() throws Exception {
        doNothing().when(userService).deleteUser(any(String.class));
        doNothing().when(projectService).deleteProject(any(Long.class));
        doNothing().when(articleService).deleteArticle(any(Long.class));
        mockMvc.perform(delete("/admin/user/{username}","name")
                .with(csrf())
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isForbidden());
        mockMvc.perform(delete("/admin/projects").with(csrf()))
                .andExpect(status().isForbidden());
        mockMvc.perform(delete("/admin/blog/{id}",1).with(csrf()))
                .andExpect(status().isForbidden());
        mockMvc.perform(delete("/admin/projects/delete/{id}",1).with(csrf()))
                .andExpect(status().isForbidden());
    }
}
@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerTestAnonymous {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private UserService userService;
    @MockBean
    private ArticleService articleService;
    @MockBean
    private ProjectService projectService;

    @Test
    void testForGetRequests() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().is3xxRedirection());
        mockMvc.perform(get("/admin/signUp"))
                .andExpect(status().is3xxRedirection());
        mockMvc.perform(get("/admin/blog/new"))
                .andExpect(status().is3xxRedirection());
        mockMvc.perform(get("/admin/projects/new"))
                .andExpect(status().is3xxRedirection());
        mockMvc.perform(get("/admin/betterdevs"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void testForPostRequests() throws Exception {
        doNothing().when(userService).signUp(any(UserEntity.class));
        doNothing().when(projectService).addProject(any(Projects.class));
        doNothing().when(articleService).addArticles(any(Articles.class));
        mockMvc.perform(post("/admin/signUp").with(csrf()))
                .andExpect(redirectedUrl("http://localhost/login"));
        mockMvc.perform(post("/admin/blog/new").with(csrf()))
                .andExpect(redirectedUrl("http://localhost/login"));
        mockMvc.perform(post("/admin/projects/new").with(csrf()))
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    void testForDeleteRequests() throws Exception {
        doNothing().when(userService).deleteUser(any(String.class));
        doNothing().when(projectService).deleteProject(any(Long.class));
        doNothing().when(articleService).deleteArticle(any(Long.class));
        mockMvc.perform(delete("/admin/user/{username}","name")
                .with(csrf())
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().is3xxRedirection());
        mockMvc.perform(delete("/admin/projects").with(csrf()))
                .andExpect(status().is3xxRedirection());
        mockMvc.perform(delete("/admin/blog/{id}",1).with(csrf()))
                .andExpect(status().is3xxRedirection());
        mockMvc.perform(delete("/admin/projects/delete/{id}",1).with(csrf()))
                .andExpect(status().is3xxRedirection());
    }
}