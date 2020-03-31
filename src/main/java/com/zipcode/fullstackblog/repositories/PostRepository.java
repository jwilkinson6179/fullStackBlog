package com.zipcode.fullstackblog.repositories;

import com.zipcode.fullstackblog.models.*;
import org.springframework.data.jpa.repository.*;

public interface PostRepository extends JpaRepository<Post, Long>
{
}
