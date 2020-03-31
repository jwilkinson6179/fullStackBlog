package com.zipcode.fullstackblog.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.zipcode.fullstackblog.domain.Post;

public interface BoardRepository extends PagingAndSortingRepository<Post, Long>
{
}