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
@RequestMapping("/api")
public class PostController
{
    private static PostService serv;
    private static BoardService brdServ;

    @Autowired
    public PostController(PostService ser, BoardService brdSer)
    {
        serv = ser;
        brdServ = brdSer;
    }

    public static PostService getServ() {
        return serv;
    }

    @GetMapping("/posts/list")
    @CrossOrigin(origins = {"https://loopyblog.herokuapp.com", "http://localhost:4200"})
    public static Collection<Post> getAllPosts() { return serv.findAll(); }

    @GetMapping("/posts/{id}")
    @CrossOrigin(origins = {"https://loopyblog.herokuapp.com", "http://localhost:4200"})
    public static ResponseEntity<?> getPost(@PathVariable Long id)
    {
        Optional<Post> p = serv.findById(id);
        return (p.isPresent()) ? new ResponseEntity<> (p, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Valid
    @PostMapping("/posts/{id}")
    @CrossOrigin(origins = {"https://loopyblog.herokuapp.com", "http://localhost:4200"})
    public ResponseEntity<?> save(@RequestBody Post post, @PathVariable long id)
    {
        Optional<Board> foundBoard = brdServ.findById(id);
        if (foundBoard.isPresent()) {
            post.setBoard(foundBoard.get());
        }
        post = serv.create(post);
        URI newPostUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();

        return new ResponseEntity<>(newPostUri, HttpStatus.CREATED);
    }

    @Valid
    @GetMapping("/posts/newest")
    @CrossOrigin(origins = {"https://loopyblog.herokuapp.com", "http://localhost:4200"})
    public Collection<Post> newPosts()
    {
        return serv.getNewestPosts();
    }

    /* CURRENT UNUSED BY FRONTEND */
    /*@GetMapping("/posts")
    public static Page<Post> getAllPosts(Pageable pageable) {  return serv.findAll(pageable); }

    @GetMapping("/posts/authors/{author}")
    public static Page<Post> getAllPosts(Pageable pageable, @PathVariable String author) { return serv.findAll(pageable, author); }

    @Valid
    @PostMapping("/posts")
    @CrossOrigin(origins = {"https://loopyblog.herokuapp.com", "http://localhost:4200"})
    public ResponseEntity<?> save(@RequestBody Post post) {
        post = serv.create(post);
        URI newPostUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();

        return new ResponseEntity<>(newPostUri, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    @CrossOrigin(origins = {"https://loopyblog.herokuapp.com", "http://localhost:4200"})
    public ResponseEntity<?> editPost(@RequestBody Post post, @PathVariable Long id) {
        serv.update(post, id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    @CrossOrigin(origins = {"https://loopyblog.herokuapp.com", "http://localhost:4200"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        serv.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/
    /* CURRENT UNUSED BY FRONTEND */
}
