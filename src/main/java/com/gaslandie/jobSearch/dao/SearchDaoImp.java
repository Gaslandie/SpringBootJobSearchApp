package com.gaslandie.jobSearch.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.gaslandie.jobSearch.entities.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class SearchDaoImp implements SearchDAO  {
    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;//to convert each element in result to java format and add it to posts

    @Override
    public List<Post> findByText(String text) {
        List<Post> posts = new ArrayList<>();

        //code from mongodb atlas,after indexation and some modification
        MongoDatabase database = client.getDatabase("gaslandie");
        MongoCollection<Document> collection = database.getCollection("jobSearch");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
                new Document("index", "default")
                .append("text", 
                new Document("query", text)
                .append("path", Arrays.asList("techs", "desc", "profile")))), 
                new Document("$sort", 
                new Document("exp", 1L)), 
                new Document("$limit", 5L)));

        result.forEach(doc -> posts.add(converter.read(Post.class,doc)));
        return posts;
    }
}