package com.zipcode.fullstackblog.controllers;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BoardController {

    private static BoardService serv;

    @Autowired
    public BoardController(BoardService ser) {
        serv = ser;
    }

    public static void save(Board board) {

    }

    public static  void saveAll(List<Board> boards) {

    }

    public static  void delete(Board board) {

    }

    public static List<Board> findAll() {
        return null;
    }

    public static  Integer count() {
        return 0;
    }
}
