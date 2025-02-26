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
    // 게시글 아이디
    private Long boardId;

    // 작성자명
    private String writer;

    // 제목
    private String title;

    // 내용
    private String content;

    private LocalDateTime createdAt;

//    private LocalDateTime modifiedAt;

    public BoardListResponseDto(Board board) {
        this.boardId = board.getBoardId();
        this.writer = board.getWriter();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.createdAt = board.getCreatedAt();
//        this.modifiedAt = board.getModifiedAt();
    }

    public BoardListResponseDto(Optional<Board> board) {
        this.boardId = board.get().getBoardId();
        this.writer = board.get().getWriter();
        this.title = board.get().getTitle();
        this.content = board.get().getContent();
        this.createdAt = board.get().getCreatedAt();
//        this.modifiedAt = board.get().getModifiedAt();
    }
}

