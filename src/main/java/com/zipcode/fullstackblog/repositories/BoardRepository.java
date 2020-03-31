package com.zipcode.fullstackblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Post, Long>
{
}