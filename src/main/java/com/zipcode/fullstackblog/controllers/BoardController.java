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
        return (p.isPresent()) ? new ResponseEntity<> (p, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Valid
    @PostMapping("/boards")
    public ResponseEntity<?> save(@RequestBody Board board)
    {
        board = serv.create(board);
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(board.getId())
                .toUri();

        return new ResponseEntity<>(newPollUri, HttpStatus.CREATED);
    }

    @PutMapping("/boards/{id}")
    public ResponseEntity<?> editBoard(@RequestBody Board post, @PathVariable Long id)
    {
        serv.create(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }


    @DeleteMapping("/boards/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        serv.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}