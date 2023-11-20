package io.github.vikie1.portfolio.projects.learnFromVictor.controller;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.Blogs;
import io.github.vikie1.portfolio.projects.learnFromVictor.entity.dao.ApiData;
import io.github.vikie1.portfolio.projects.learnFromVictor.service.BlogService;
import io.github.vikie1.portfolio.projects.learnFromVictor.util.BlogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String,List<Blogs>> response = new HashMap<>();
        response.put("blog", blogService.getAll());
        return response;
    }
    @GetMapping("/blogs/{topics}")
    public Map<String, List<Blogs>> getByTopics(@PathVariable("topics") String topics){
        Map<String,List<Blogs>> response = new HashMap<>();
        response.put("blog", blogService.getByTopics(topics));
        return response;
    }

    //PUT
    @PutMapping("/blogs")
    public void updateBlog(@RequestBody ApiData.Blog blog){blogService.update(BlogUtil.retrieveBlog(blog));}

    //DELETE
    @DeleteMapping("/blogs/{id}")
    public void deleteBlog(@PathVariable("id") long id){blogService.delete(id);}
}
