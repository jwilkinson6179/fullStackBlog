package com.zipcode.fullstackblog.controllers;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

public class PostController
{

    private PostService postService;

    @Autowired
    public PostController(PostService postService)
    {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public Page<Post> getAllPosts(Pageable pageable)
    {
        return postService.findAll(pageable);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long postId)
    {
        Optional<Post> p = postService.findById(postId);
        return new ResponseEntity<> (p, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<?> findById(@PathVariable long id)
    {
        return this.postService.findById(id)
                .map(post -> ResponseEntity
                        .ok()
                        .body(post))
                .orElse(ResponseEntity
                        .notFound()
                        .build());
    }

    @Valid
    @PostMapping("/post")
    public ResponseEntity<?> save(Post post)
    {
        post = postService.create(post);
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();

        return new ResponseEntity<>(newPollUri, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<?> editPost(@RequestBody Post post, @PathVariable Long postId)
    {
        postService.create(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }


    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> delete(Long postId)
    {
        postService.delete(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @DeleteMapping("/posts/all")
//    public ResponseEntity<?> deleteAll()
//    {
//        postService.deleteAll();
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

//    public Integer count()
//    {
//        return 0;
//    }
}