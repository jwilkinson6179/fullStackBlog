package com.zipcode.fullstackblog.controllers;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.services.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

public class PostController {

    private PostService serv;

    @Autowired
    public PostController(PostService serv) {
        this.serv = serv;
    }

    public void save(Post post) {

    }

    public void saveAll(List<Post> posts) {

    }

    public void delete(Post post) {

    }

    public void deleteAll() {

    }

    public List<Post> findAll() {
        return null;
    }

    public Integer count() {
        return 0;
    }
}
