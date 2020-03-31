package com.zipcode.fullstackblog.repositories;

import com.zipcode.fullstackblog.domain.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long>
{
}
