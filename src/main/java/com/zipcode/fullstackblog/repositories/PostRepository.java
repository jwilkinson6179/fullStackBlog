package com.zipcode.fullstackblog.repositories;

import com.zipcode.fullstackblog.models.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>
{
    @Query("SELECT p FROM Post p WHERE p.author = :author")
    Page<Post> findAllByName(Pageable page, @Param("author") String author);
}