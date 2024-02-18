package com.gaslandie.jobSearch.dao;

import java.util.List;

import com.gaslandie.jobSearch.entities.Post;

public interface SearchDAO  {
    List<Post> findByText(String text);
}
