package com.zipcode.fullstackblog.services;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class TagService {

    private TagRepository repo;

    @Autowired
    public TagService(TagRepository repo) {
        this.repo = repo;
    }

    public void save(Tag tag) {

    }

    public void saveAll(List<Tag> tags) {

    }

    public void delete(Tag tag) {

    }

    public List<Tag> findAll() {
        return null;
    }

    public Integer count() {
        return 0;
    }

}
