package com.zipcode.fullstackblog.controllers;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class PostController
{
    private static PostService serv;

    @Autowired
    public PostController(PostService ser)
    {
        serv = ser;
    }

    @GetMapping("/posts")
    public static Page<Post> getAllPosts(Pageable pageable)
    {
        return serv.findAll(pageable);
    }

    @GetMapping("/posts/authors/{author}")
    public static Page<Post> getAllPosts(Pageable pageable, @PathVariable String author)
    {
        return serv.findAll(pageable, author);
    }

    @GetMapping("/posts/tags/{tag}")
    public static Page<Post> getAllPosts(Pageable pageable, @PathVariable Tag tag)
    {
        return null;
    }

    @GetMapping("/posts/{id}")
    public static ResponseEntity<?> getPost(@PathVariable Long id)
    {
        Optional<Post> p = serv.findById(id);
        if(p.isPresent())
        {
            return new ResponseEntity<> (p, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Valid
    @PostMapping("/posts")
    public ResponseEntity<?> save(@RequestBody Post post)
    {
        post = serv.create(post);
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();

        return new ResponseEntity<>(newPollUri, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<?> editPost(@RequestBody Post post, @PathVariable Long id)
    {
        serv.create(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }


    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        serv.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


/*
        @DeleteMapping("/posts/all")
    public ResponseEntity<?> deleteAll()
    {
        postService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/
}