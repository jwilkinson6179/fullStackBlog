package com.zipcode.fullstackblog.controllers;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.services.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

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

    public static  void deleteAll() {

    }

    public  static List<Post> findAll() {
        return null;
    }

    public  static Integer count() {
        return 0;
    }
}
