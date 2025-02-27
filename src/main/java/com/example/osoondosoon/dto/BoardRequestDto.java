package com.example.osoondosoon.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardRequestDto {
    private String writer; // 임시
    
    private String title;

    private String content;
}