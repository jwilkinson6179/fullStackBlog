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
        this.repo.save(tag);
    }

    public void saveAll(List<Tag> tags) {
        this.repo.saveAll(tags);
    }

    public Boolean delete(Tag tag) {
        this.repo.delete(tag);
        return findById(tag.getId()).isPresent();


    }
    public Optional<Tag> findById(long id) {
        return this.repo.findById(id);
    }

    public List<Tag> findAll() {
        return this.repo.findAll();
    }

    public Long count() {
        return repo.count();
    }

}
