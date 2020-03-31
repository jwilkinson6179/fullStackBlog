package com.zipcode.fullstackblog.controllers;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.services.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

public class TagController {

    private TagService serv;

    @Autowired
    public TagController(TagService serv) {
        this.serv = serv;
    }

    public void save(Tag tag) {

    }

    public void saveAll(List<Tag> tags) {

    }

    public void delete(Tag tag) {

    }

    public void deleteAll() {

    }

    public List<Tag> findAll() {
        return null;
    }

    public Integer count() {
        return 0;
    }

}
