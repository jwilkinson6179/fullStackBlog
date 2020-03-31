package com.zipcode.fullstackblog.repositories;

import com.zipcode.fullstackblog.domain.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TagRepository extends PagingAndSortingRepository<Post, Long>
{
}
