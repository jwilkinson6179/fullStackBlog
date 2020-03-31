package com.zipcode.fullstackblog.services;

import com.zipcode.fullstackblog.models.Post;
import com.zipcode.fullstackblog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostService
{
    PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository)
    {
        this.postRepository = postRepository;
    }

    public void save(Post post)
    {

    }

    public void saveAll(List<Post> listOfPosts)
    {

    }
}