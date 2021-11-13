package io.github.vikie1.portfolio.projects.betterdevs.controller;

import io.github.vikie1.portfolio.projects.betterdevs.entity.dao.ApiData;
import io.github.vikie1.portfolio.projects.betterdevs.service.BlogService;
import io.github.vikie1.portfolio.projects.betterdevs.util.BlogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/betterdevs")
public class BlogsController {
    @Autowired
    BlogService blogService;

    //POST
    @PostMapping("/blog")
    public void newBlog(@RequestBody ApiData.Blog blog){
        blogService.save(BlogUtil.retrieveBlog(blog));
    }
}
