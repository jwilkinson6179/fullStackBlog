package com.zipcode.fullstackblog.repositories;

import com.zipcode.fullstackblog.models.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{

    List<Tag> findAll();

    @Query("SELECT t FROM Tag t WHERE t.name = :name")
    Optional<Tag> findByName(String name);
}
