package com.zipcode.fullstackblog.services;

import com.zipcode.fullstackblog.models.Post;
import com.zipcode.fullstackblog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class PostService {

    private PostRepository postRepository;

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

    public void delete(Post post)
    {
    }

    public void deleteAll()
    {
    }

    public List<Post> findAll()
    {
        return null;
    }

    public Integer count()
    {
        return 0;
    }
}