package com.zipcode.fullstackblog.services;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class CommentService {

    private final CommentRepository repo;

    @Autowired
    public CommentService(CommentRepository repo) {
        this.repo = repo;
    }

    public Comment create(Comment comment) { return this.repo.save(comment); }

    public List<Comment> findAll() { return this.repo.findAll(); }

    public Page<Comment> findAll(Pageable pageable) {
        return repo.findAll(pageable); }

    public Optional<Comment> findById(long commentID) { return this.repo.findById(commentID); }

    public Boolean delete(long boardId)
    {
        this.repo.deleteById(boardId);
        return findById(boardId).isPresent();
    }

}
