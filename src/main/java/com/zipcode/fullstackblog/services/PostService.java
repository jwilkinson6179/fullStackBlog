package com.zipcode.fullstackblog.services;

import com.zipcode.fullstackblog.models.Post;
import com.zipcode.fullstackblog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository)
    {
        this.postRepository = postRepository;
    }

    public Post create(Post car)
    {
        return this.postRepository.save(car);
    }

//    public void createAll(List<Post> listOfPosts)
//    {
//    }

    public Page<Post> findAll(Pageable pageable)
    {
        return postRepository.findAll(pageable);
    }

    public Optional<Post> findById(long postId)
    {
        return this.postRepository.findById(postId);
    }

    public Boolean delete(long pollId)
    {
        this.postRepository.deleteById(pollId);

        return findById(pollId).isPresent();
    }

//    public Integer count()
//    {
//        return 0;
//    }
}