package com.gaslandie.jobSearch.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gaslandie.jobSearch.entities.Post;

public interface PostDAO extends MongoRepository<Post,String> {
    
}
