package com.zipcode.fullstackblog.controllers;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.services.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

public class BoardController {

    private BoardService serv;

    @Autowired
    public BoardController(BoardService serv) {
        this.serv = serv;
    }

    public void save(Board board) {

    }

    public void saveAll(List<Board> boards) {

    }

    public void delete(Board board) {

    }

    public void deleteAll() {

    }

    public List<Board> findAll() {
        return null;
    }

    public Integer count() {
        return 0;
    }
}
