package com.example.osoondosoon.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardRequestDto {
    private String writer;

    private String title;

    private String content;
}