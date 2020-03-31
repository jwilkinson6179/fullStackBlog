package com.zipcode.fullstackblog.controllers;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TagController {

    private static TagService serv;

    @Autowired
    public TagController(TagService ser) {
        serv = ser;
    }

    public static void save(Tag tag) {

    }

    public static void saveAll(List<Tag> tags) {

    }

    public static void delete(Tag tag) {

    }

    public static List<Tag> findAll() {
        return null;
    }

    public static Integer count() {
        return 0;
    }

}
