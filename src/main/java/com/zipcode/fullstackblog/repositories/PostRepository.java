package com.zipcode.fullstackblog.repositories;

import com.zipcode.fullstackblog.models.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>
{
    @Query("SELECT p FROM Post p WHERE p.author = :author")
    Page<Post> findAllByName(Pageable page, @Param("author") String author);

    @Query(value = "SELECT * FROM post p ORDER BY p.create_timestamp DESC LIMIT :numberOfPosts",
            nativeQuery = true)
    Collection<Post> findNewPosts(@Param("numberOfPosts") Integer numberOfPosts);

    @Query(value = "SELECT * FROM post p LEFT JOIN tagged_posts tp ON tp.post_id = p.id JOIN tag t ON t.id = tp.tag_id WHERE t.name = :searchedTag",
    nativeQuery = true)
    Collection<Post> findByTag(@Param("searchedTag") String searchedTag);
}
