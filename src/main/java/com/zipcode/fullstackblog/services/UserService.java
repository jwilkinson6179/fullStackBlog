package com.zipcode.fullstackblog.services;

import com.zipcode.fullstackblog.models.*;
import com.zipcode.fullstackblog.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UserService {

    private UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User create(User user) { return this.repo.save(user); }

    public List<User> findAll() { return this.repo.findAll(); }

    public Page<User> findAll(Pageable pageable) {
        return repo.findAll(pageable); }

    public Optional<User> findById(long userID) { return this.repo.findById(userID); }

    public Boolean delete(long boardId)
    {
        this.repo.deleteById(boardId);
        return findById(boardId).isPresent();
    }

}
