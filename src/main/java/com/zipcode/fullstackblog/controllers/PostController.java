package com.zipcode.fullstackblog.controllers;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PostController {

    private static PostService serv;

    @Autowired
    public PostController(PostService ser) {
        serv = ser;
    }

    public  static void save(Post post) {

    }

    public  static void saveAll(List<Post> posts) {

    }

    public static  void delete(Post post) {

    }

    public void editPost(Long id, Post updatedPost) {

    }

    public  static List<Post> findAll() {
        return null;
    }

    public  static Integer count() {
        return 0;
    }
}
