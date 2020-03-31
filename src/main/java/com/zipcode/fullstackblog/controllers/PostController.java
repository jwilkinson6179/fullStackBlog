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

    @GetMapping("/posts/{id}")
    public static ResponseEntity<?> getPost(@PathVariable Long id)
    {
        Optional<Post> p = serv.findById(id);
        return new ResponseEntity<> (p, HttpStatus.OK);
    }

    @Valid
    @PostMapping("/posts")
    public ResponseEntity<?> save(Post post)
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
}