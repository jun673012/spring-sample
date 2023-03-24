package com.example.spring_sample.repository;

import com.example.spring_sample.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
