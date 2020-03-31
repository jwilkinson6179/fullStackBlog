package com.zipcode.fullstackblog.repositories;


import com.zipcode.fullstackblog.models.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
}
