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
public class BoardController {

    private static BoardService serv;

    @Autowired
    public BoardController(BoardService ser) {
        serv = ser;
    }

    @GetMapping("/boards")
    public static Page<Board> getAllBoards(Pageable pageable)
    {
        return serv.findAll(pageable);
    }

    @GetMapping("/boards/{id}")
    public static ResponseEntity<?> getBoard(@PathVariable Long id)
    {
        Optional<Board> p = serv.findById(id);
        return new ResponseEntity<> (p, HttpStatus.OK);
    }

    @Valid
    @PostMapping("/boards")
    public ResponseEntity<?> save(Board tag)
    {
        tag = serv.create(tag);
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tag.getId())
                .toUri();

        return new ResponseEntity<>(newPollUri, HttpStatus.CREATED);
    }

    @PutMapping("/boards/{id}")
    public ResponseEntity<?> editBoard(@RequestBody Board tag, @PathVariable Long id)
    {
        serv.create(tag);
        return new ResponseEntity<>(tag, HttpStatus.CREATED);
    }


    @DeleteMapping("/boards/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        serv.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}