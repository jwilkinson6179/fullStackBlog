package com.zipcode.fullstackblog.repositories;

import com.zipcode.fullstackblog.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long>
{
}