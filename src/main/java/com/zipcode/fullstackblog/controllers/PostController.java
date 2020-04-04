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
import java.util.*;

@RestController
public class PostController
{
    @Autowired
    private static PostService serv;

    @Autowired
    public PostController(PostService ser)
    {
        serv = ser;
    }

    public static PostService getServ() {
        return serv;
    }

    @GetMapping("/posts")
    public static Page<Post> getAllPosts(Pageable pageable)
    {
        return serv.findAll(pageable);
    }

    @GetMapping("/posts/list")
    public static Collection<Post> getAllPosts() { return serv.findAll(); }

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
    @CrossOrigin(origins = "http://secure-basin-65461.herokuapp.com")
    public static ResponseEntity<?> getPost(@PathVariable Long id)
    {
        Optional<Post> p = serv.findById(id);
        return (p.isPresent()) ? new ResponseEntity<> (p, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Valid
    @PostMapping("/posts")
    public ResponseEntity<?> save(@RequestBody Post post)
    {
        post = serv.create(post);
        URI newPostUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();

        return new ResponseEntity<>(newPostUri, HttpStatus.CREATED);
    }



    @PutMapping("/posts/{id}")
    public ResponseEntity<?> editPost(@RequestBody Post post, @PathVariable Long id)
    {
        serv.update(post, id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        serv.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
