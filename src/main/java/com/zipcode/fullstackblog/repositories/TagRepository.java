package com.zipcode.fullstackblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Post, Long>
{
}
