package com.zipcode.fullstackblog.services;

import com.zipcode.fullstackblog.models.Post;
import com.zipcode.fullstackblog.models.Tag;
import com.zipcode.fullstackblog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.Set;


@Service
public class PostService
{
    private PostRepository repo;

    @Autowired
    public PostService(PostRepository repo) { this.repo = repo; }

    public Post create(Post newPost)
    {
        return this.repo.save(newPost);
    }

    public Page<Post> findAll(Pageable pageable) { return repo.findAll(pageable); }

    public Optional<Post> findById(long postId) { return this.repo.findById(postId); }

    public Page<Post> findAll(Pageable pageable, String author)
    {
        return repo.findAllByName(pageable, author);
    }

    public Post update(Post newPost, Long postId)
    {
        Post updatedPost = repo.findById(postId)
                .map(post ->
                {
                    post.setBoard(newPost.getBoard());
                    post.setHeader(newPost.getHeader());
                    post.setAuthor(newPost.getAuthor());
                    post.setText(newPost.getText());
                    post.setImageUrl(newPost.getImageUrl());
                    post.setTags(newPost.getTags());
//                    Set<Tag> tagsForPost = newPost.getTags();
//                    System.out.println(tagsForPost);
//                    for(Tag tags : tagsForPost)
//                    {
//                        post.addTag(tags);
//                    }
                    return repo.save(post);
                })
                .orElseGet(() ->
                {
//                    newPost.setCreateTimestamp(new Date());
                    return repo.save(newPost);
                });

        return updatedPost;
    }

    public Boolean delete(long postId)
    {
        this.repo.deleteById(postId);
        return findById(postId).isPresent();
    }
}