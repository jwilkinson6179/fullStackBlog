package com.zipcode.fullstackblog.controllers;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    @DeleteMapping("/tags")
    public static void delete(@RequestBody Tag tag) {
        serv.delete(tag);

    }

    public static Integer count() {
        return 0;
    }

}
