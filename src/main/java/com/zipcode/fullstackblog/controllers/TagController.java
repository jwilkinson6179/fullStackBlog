package com.zipcode.fullstackblog.controllers;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.*;

import javax.validation.*;
import java.net.*;
import java.util.*;

@RestController
public class TagController {

    private static TagService serv;

    @Autowired
    public TagController(TagService ser) {
        serv = ser;
    }

    @GetMapping("/tags")
    public static Page<Tag> getAllTags(Pageable pageable)
    {
        return serv.findAll(pageable);
    }

    @GetMapping("/tags/{id}")
    public static ResponseEntity<?> getTag(@PathVariable Long id)
    {
        Optional<Tag> p = serv.findById(id);
        return new ResponseEntity<> (p, HttpStatus.OK);
    }

    @Valid
    @PostMapping("/tags")
    public ResponseEntity<?> save(Tag tag)
    {
        tag = serv.create(tag);
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tag.getId())
                .toUri();

        return new ResponseEntity<>(newPollUri, HttpStatus.CREATED);
    }

    @PutMapping("/tags/{id}")
    public ResponseEntity<?> editTag(@RequestBody Tag tag, @PathVariable Long id)
    {
        serv.create(tag);
        return new ResponseEntity<>(tag, HttpStatus.CREATED);
    }


    @DeleteMapping("/tags/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        serv.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
