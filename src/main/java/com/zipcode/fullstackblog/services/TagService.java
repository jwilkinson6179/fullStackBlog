package com.zipcode.fullstackblog.services;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class TagService {

    private TagRepository repo;

    @Autowired
    public TagService(TagRepository repo) {
        this.repo = repo;
    }

    public Tag create(Tag tag) { return this.repo.save(tag); }

    public Page<Tag> findAll(Pageable pageable) { return repo.findAll(pageable); }

    public List<Tag> findAll() { return repo.findAll(); }

    public Optional<Tag> findById(long tagId) { return this.repo.findById(tagId); }

    public Boolean delete(long boardId)
    {
        this.repo.deleteById(boardId);
        return findById(boardId).isPresent();
    }
}