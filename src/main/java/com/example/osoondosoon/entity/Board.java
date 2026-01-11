package com.example.osoondosoon.entity;

import com.example.osoondosoon.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Board extends TimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    // ✅ 카테고리 추가
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private BoardCategory category;

    public Board(BoardRequestDto requestDto) {
        this.writer = requestDto.getWriter();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        // 요청값 없으면 기본값(자유게시판)
        this.category = requestDto.getCategory() != null ? requestDto.getCategory() : BoardCategory.FREE;
    }

    public void update(BoardRequestDto requestDto) {
        this.writer = requestDto.getWriter();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();

        // 수정 시 카테고리도 변경 허용(원하면 제거 가능)
        if (requestDto.getCategory() != null) {
            this.category = requestDto.getCategory();
        }
    }
}
