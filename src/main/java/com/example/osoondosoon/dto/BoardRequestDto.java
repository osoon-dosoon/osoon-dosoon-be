package com.example.osoondosoon.dto;

import com.example.osoondosoon.entity.BoardCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardRequestDto {
    private String writer;
    private String title;
    private String content;

    // ✅ 추가
    private BoardCategory category;
}
