package com.gaslandie.jobSearch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaslandie.jobSearch.dao.SearchDaoImp;
import com.gaslandie.jobSearch.entities.Post;

@Service
public class SearchService {
    @Autowired
    SearchDaoImp searchDaoImp;

    public List<Post> findByText(String text) {
        return searchDaoImp.findByText(text);
    }

}
