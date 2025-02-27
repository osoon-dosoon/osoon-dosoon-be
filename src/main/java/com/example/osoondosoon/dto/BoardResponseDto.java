package com.example.osoondosoon.dto;

import com.example.osoondosoon.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BoardResponseDto {
    private Long boardId;

    private String writer;

    private String title;

    private String content;

    private LocalDateTime createdAt;

//    private LocalDateTime modifiedAt;

    public BoardResponseDto(Board board) {
        this.boardId = board.getBoardId();
        this.writer = board.getWriter();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.createdAt = board.getCreatedAt();
//        this.modifiedAt = board.getModifiedAt();
    }
}
