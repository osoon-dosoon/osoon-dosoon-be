package com.example.osoondosoon.entity;

import com.example.osoondosoon.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Board extends TimeStamp {
    // 글 고유 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    // 작성자
    @Column(nullable = false)
    private String writer;

    // 글 제목
    @Column(nullable = false)
    private String title;

    // 글 내용
    @Column(nullable = false)
    private String content;

//    // 글 작성 시간
//    @CreationTimestamp  // 자동으로 현재 시간을 저장
//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//
//    // 글 수정 시간
//    @UpdateTimestamp  // 수정될 때 자동으로 업데이트
//    private LocalDateTime modifiedAt;

    public Board(BoardRequestDto requestDto) {
        this.writer = requestDto.getWriter();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public void update(BoardRequestDto requestDto) {
        this.writer = requestDto.getWriter();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}