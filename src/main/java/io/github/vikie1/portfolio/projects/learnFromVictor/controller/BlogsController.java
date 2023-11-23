package io.github.vikie1.portfolio.projects.learnFromVictor.controller;

import io.github.vikie1.portfolio.articles.Articles;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.Blogs;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.dao.ApiData;
import io.github.vikie1.portfolio.projects.learnFromVictor.service.BlogService;
import io.github.vikie1.portfolio.projects.learnFromVictor.service.BlogService.BlogWithRelated;
import io.github.vikie1.portfolio.projects.learnFromVictor.util.BlogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController @RequestMapping("/api/lfv")
public class BlogsController {
    @Autowired
    BlogService blogService;

    //POST
    @PostMapping("/blogs")
    public void newBlog(@RequestBody ApiData.Blog blog){
        blogService.save(BlogUtil.retrieveBlog(blog));
    }

    //GET
    @GetMapping("/blogs")
    public Map<String, List<Blogs>> getBlogs(){
        Map<String, List<Blogs>> response = new HashMap<>();
        response.put("blog", blogService.getAll());
        return response;
    }
    @GetMapping("/blogs/topics/{topics}")
    public Map<String, List<Blogs>> getByTopics(@PathVariable("topics") String topics){
        Map<String, List<Blogs>> response = new HashMap<>();
        response.put("blog", blogService.getByTopics(topics));
        return response;
    }
    @GetMapping("/blogs/published")
    public Map<String, List<Blogs>> getPublished() {
        Map<String, List<Blogs>> response = new HashMap<>();
        response.put("blog", blogService.getByPublished(true));
        return response;
    }
    @GetMapping("/blogs/id/{id}")
    public BlogWithRelated getBlogAndRelatedArticles(@PathVariable("id") long id){
        return blogService.getWithRelated(id);
    }

    //PUT
    @PutMapping("/blogs")
    public void updateBlog(ApiData.Blog blog){
        // blogService.update(BlogUtil.retrieveBlog(blog));
        String blogString = """
            {
                name: %s,
                publishDate: some date,
                imgURL: %s,
                description: %s,
                topic: %s,
                fullArticle: %s
            }
        """.formatted(blog.name(), blog.imgURL(), blog.description(), blog.topics().length + Arrays.toString(blog.topics()), blog.post());
        Logger.getLogger("Put Test").log(Level.INFO, blogString);
    }
    @PutMapping("/blogs/new")
    public void updateBlogTest(Articles blog){Logger.getLogger("Put Test").log(Level.INFO, blog.toString());}

    //DELETE
    @DeleteMapping("/blogs/id/{id}")
    public void deleteBlog(@PathVariable("id") long id){blogService.delete(id);}
}
