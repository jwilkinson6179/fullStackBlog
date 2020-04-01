package com.zipcode.fullstackblog.services;

import com.zipcode.fullstackblog.models.Post;
import com.zipcode.fullstackblog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.*;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository repo;

    @Autowired
    public PostService(PostRepository repo) { this.repo = repo; }

    public Post create(Post post) { return this.repo.save(post); }

    public Page<Post> findAll(Pageable pageable) { return repo.findAll(pageable); }

    public Optional<Post> findById(long postId) { return this.repo.findById(postId); }

    public Page<Post> findAll(Pageable pageable, String author) {
        return repo.findAllByName(pageable, author);
    }

    public Boolean delete(long pollId)
    {
        this.repo.deleteById(pollId);
        return findById(pollId).isPresent();
    }
}