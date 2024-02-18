package com.gaslandie.jobSearch.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaslandie.jobSearch.entities.Post;
import com.gaslandie.jobSearch.services.PostService;

import springfox.documentation.annotations.ApiIgnore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class PostController {
    @Autowired
    PostService postService;

    @ApiIgnore //to ignore predefined requests by swagger
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException{
        response.sendRedirect("/swagger-ui.html");
    }
    //post a post(job)
    @PostMapping("/post")
    public Post addPost(@RequestBody Post post) {
        
       return postService.addPost(post);
    }
    

    //fetch all the posts
    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }
}
