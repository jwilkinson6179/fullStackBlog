package com.zipcode.fullstackblog.services;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class BoardService {

    private BoardRepository repo;

    @Autowired
    public BoardService(BoardRepository repo) {
        this.repo = repo;
    }

    public Board create(Board board) { return this.repo.save(board); }

    public List<Board> findAll() { return this.repo.findAll(); }

    public Page<Board> findAll(Pageable pageable) {
        return repo.findAll(pageable); }

    public Optional<Board> findById(long boardId) { return this.repo.findById(boardId); }

    public Boolean delete(long boardId)
    {
        this.repo.deleteById(boardId);
        return findById(boardId).isPresent();
    }

}
