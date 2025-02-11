package com.example.osoondosoon.entity;

import com.example.osoondosoon.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "users")
public class Board extends TimeStamp {
    // 글 고유 아이디
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 글 제목
    @Column(nullable = false)
    private String title;

    // 글 내용
    @Column(nullable = false)
    private String content;

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}