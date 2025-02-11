package com.example.osoondosoon.repository;

import com.example.osoondosoon.dto.BoardListResponseDto;
import com.example.osoondosoon.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<BoardListResponseDto> findAllByOrderByModifiedAtDesc();
}
