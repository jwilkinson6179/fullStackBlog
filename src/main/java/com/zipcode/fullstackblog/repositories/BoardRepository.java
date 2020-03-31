package com.zipcode.fullstackblog.repositories;

import com.zipcode.fullstackblog.models.*;
import org.springframework.data.jpa.repository.*;

public interface BoardRepository extends JpaRepository<Board, Long>{
}