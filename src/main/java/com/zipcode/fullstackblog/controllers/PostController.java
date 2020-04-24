package com.zipcode.fullstackblog.controllers;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cloud.cloudfoundry.*;
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
    private TagService tagService;

    @Autowired
    public PostController(PostService ser, BoardService brdSer, TagService tagService)
    {
        serv = ser;
        brdServ = brdSer;
        this.tagService = tagService;
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
    public ResponseEntity<?> save(@RequestBody Post post, @PathVariable long id, @RequestParam String tag)
    {
        String[] splice = tag.split(" ");
        for (String s : splice) {
            Optional<Tag> tagg = tagService.findByName(s);
            Tag createdTag;
            createdTag = tagg.orElseGet(() -> new Tag(s));
            createdTag.addPost(post);
            post.addTag(createdTag);
        }
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

    @Valid
    @GetMapping("/posts/newest/{numberOfPosts}")
    @CrossOrigin(origins = {"https://loopyblog.herokuapp.com", "http://localhost:4200"})
    public Collection<Post> newPosts(@PathVariable Integer numberOfPosts)
    {
        return serv.getNewestPosts(numberOfPosts);
    }
    @PutMapping("/posts/{id}")
    @CrossOrigin(origins = {"https://loopyblog.herokuapp.com", "http://localhost:4200"})
    public ResponseEntity<?> editPost(@RequestBody Post post, @PathVariable Long id) {
        serv.update(post, id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @Valid
    @GetMapping("/posts/tag/{tagName}")
    @CrossOrigin(origins = {"https://loopyblog.herokuapp.com", "http://localhost:4200"})
    public Collection<Post> postsByTag(@PathVariable String tagName)
    {
        return serv.findByTag(tagName);
    }
    @DeleteMapping("/posts/{id}")
    @CrossOrigin(origins = {"https://loopyblog.herokuapp.com", "http://localhost:4200"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        serv.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Valid
    @GetMapping("/posts/tag")
    @CrossOrigin(origins = {"https://loopyblog.herokuapp.com", "http://localhost:4200"})
    public ResponseEntity<?> searchByTag(@RequestParam String search, @RequestParam(required = false) Boolean all)
    {
        String[] arrayOfSearchTerms = search.split(" ");
        ArrayList<String> sterms = new ArrayList<>();
        for (String s : arrayOfSearchTerms) { sterms.add(s.toLowerCase()); }
        Iterable<Post> results = serv.searchByAllTags(arrayOfSearchTerms);
        List<Post> filtered = new ArrayList<>();
        if (all != null && all) {
            for (Post r: results) {
                if (r.getTags().size() != arrayOfSearchTerms.length) { continue; }
                boolean allMatching = true;
                for (Tag t : r.getTags()) {
                    if (!sterms.contains(t.getName().toLowerCase())) {
                        allMatching = false;
                        break;
                    }
                }
                if (allMatching) {
                    filtered.add(r);
                }
            }
        }
        return all != null && all ? new ResponseEntity<>(filtered, HttpStatus.OK) : new ResponseEntity<>(results, HttpStatus.OK);
    }
}
