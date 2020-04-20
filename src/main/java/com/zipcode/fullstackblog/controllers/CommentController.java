package com.zipcode.fullstackblog.controllers;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.*;

import javax.validation.*;
import java.net.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    private static CommentService serv;
    private static PostService pstServ;

    @Autowired
    public CommentController(CommentService ser, PostService pstSer) {
        serv = ser;
        pstServ = pstSer;
    }

    public static CommentService getServ() {
        return serv;
    }

    @GetMapping("/comments/{id}")
    @CrossOrigin(origins = {"https://loopyblog.herokuapp.com", "http://localhost:4200"})
    public static ResponseEntity<?> getComments(@PathVariable Long id)
    {
        Optional<Post> p = pstServ.findById(id);
        return (p.isPresent()) ? new ResponseEntity<> (p.get().getComments(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Valid
    @PostMapping("/comments/{id}")
    @CrossOrigin(origins = {"https://loopyblog.herokuapp.com", "http://localhost:4200"})
    public ResponseEntity<?> save(@RequestBody Comment post, @PathVariable long id)
    {
        Optional<Post> foundBoard = pstServ.findById(id);
        if (foundBoard.isPresent()) {
            post.setPost(foundBoard.get());
        }
        post = serv.create(post);
        URI newPostUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();

        return new ResponseEntity<>(newPostUri, HttpStatus.CREATED);
    }

}
