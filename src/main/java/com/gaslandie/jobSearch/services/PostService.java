package com.gaslandie.jobSearch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaslandie.jobSearch.dao.PostDAO;
import com.gaslandie.jobSearch.entities.Post;

@Service
public class PostService {
    @Autowired
    PostDAO postDAO;
    public List<Post> getAllPosts() {
        return postDAO.findAll();
    }
    public Post addPost(Post post) {
       return postDAO.save(post);
    }

}
