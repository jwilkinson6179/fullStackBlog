package com.zipcode.fullstackblog.services;

import com.zipcode.fullstackblog.controllers.*;
import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;


@Service
public class PostService
{
    private PostRepository repo;

    @Autowired
    public PostService(PostRepository repo) { this.repo = repo; }

    public Post create(Post post)
    {
        boolean found = false;
        if (post.getBoard() != null) {
            for (Board b : BoardController.getServ().findAll()) {
                if (b.getTitle().equals(post.getBoard().getTitle())) {
                    post.setBoard(b);
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            if (post.getBoard() == null) {
                BoardController.getServ().create(new Board("General"));
            } else {
                BoardController.getServ().create(post.getBoard());
            }
        }
        return this.repo.save(post);
    }

    public Page<Post> findAll(Pageable pageable) { return repo.findAll(pageable); }

    public List<Post> findAll() { return repo.findAll(); }

    public Optional<Post> findById(long postId) { return this.repo.findById(postId); }

    public Page<Post> findAll(Pageable pageable, String author)
    {
        return repo.findAllByName(pageable, author);
    }

    public Post update(Post newPost, Long postId)
    {
        return repo.findById(postId)
                .map(post ->
                {
                    post.setBoard(newPost.getBoard());
                    post.setHeader(newPost.getHeader());
                    post.setAuthor(newPost.getAuthor());
                    post.setText(newPost.getText());
                    post.setImageUrl(newPost.getImageUrl());
                    post.setTags(newPost.getTags());
                    return repo.save(post);
                })
                .orElseGet(() -> repo.save(newPost));
    }

    public Boolean delete(long postId)
    {
        this.repo.deleteById(postId);
        return findById(postId).isPresent();
    }
}