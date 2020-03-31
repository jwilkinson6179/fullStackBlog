package com.zipcode.fullstackblog.services;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class PostService {

    private PostRepository repo;

    @Autowired
    public PostService(PostRepository repo) {
        this.repo = repo;
    }

    public void save(Post post) {

    }

    public void saveAll(List<Post> posts) {

    }

    public void delete(Post post) {

    }

    public void editPost(Long id, Post updatedPost) {

    }

    public List<Post> findAll() {
        return null;
    }

    public Integer count() {
        return 0;
    }
}
