package com.example.osoondosoon.dto;

import com.example.osoondosoon.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardListResponseDto {
    // 제목
    private String title;

    // 작성자명
    private String username;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    public BoardListResponseDto(Board board) {
        this.title = board.getTitle();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }

    public BoardListResponseDto(Optional<Board> board) {
        this.title = board.get().getTitle();
        this.createdAt = board.get().getCreatedAt();
        this.modifiedAt = board.get().getModifiedAt();
    }
}

