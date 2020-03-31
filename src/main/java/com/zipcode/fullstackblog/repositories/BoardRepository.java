package com.zipcode.fullstackblog.repositories;
import com.zipcode.fullstackblog.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}