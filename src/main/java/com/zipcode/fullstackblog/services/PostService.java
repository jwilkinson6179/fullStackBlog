package com.zipcode.fullstackblog.services;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class PostService
{
    private PostRepository repo;
    private BoardRepository boardRepo;

    @Autowired
    public PostService(PostRepository repo, BoardRepository brdRepo) {
        this.repo = repo;
        this.boardRepo = brdRepo;
    }

    public Post create(Post post)
    {
        boolean found = false;
        if (post.getBoard() != null) {
            for (Board b : boardRepo.findAll()) {
                if (b != null && post.getBoard() != null && b.getTitle() != null) {
                    if (b.getTitle().equals(post.getBoard().getTitle())) {
                        post.setBoard(b);
                        found = true;
                        break;
                    }
                }
            }
        }
        if (!found) {
            if (post.getBoard() == null) {
                boardRepo.save(new Board("General"));
            } else {
                boardRepo.save(post.getBoard());
            }
        }

        return this.repo.save(post);
    }

    public Page<Post> findAll(Pageable pageable) { return repo.findAll(pageable); }

    public Collection<Post> findAll() { return repo.findAll(); }

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

    public Collection<Post> getNewestPosts()
    {
        return repo.findNewPosts(5);
    }

    public Collection<Post> getNewestPosts(Integer numberOfPosts)
    {
        return repo.findNewPosts(numberOfPosts);
    }

    public Collection<Post> findByTag(String searchTerm)
    {
        return repo.findByTag(searchTerm);
    }

    public Collection<Post> searchByAllTags(String[] searchTerms)
    {
        Set<Post> results = new HashSet<>();

        for(Integer i = 0; i < searchTerms.length; i++)
        {
            String term = searchTerms[i];
            results.add((Post) findByTag(term));
        }

        return results;
    }
}
