package com.zipcode.fullstackblog.services;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.repositories.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

public class BoardService {

    private BoardRepository repo;

    @Autowired
    public BoardService(BoardRepository repo) {
        this.repo = repo;
    }

    public void save(Board board) {

    }

    public void saveAll(List<Board> boards) {

    }

    public void delete(Board board) {

    }

    public List<Board> findAll() {
        return null;
    }

    public Integer count() {
        return 0;
    }

}
