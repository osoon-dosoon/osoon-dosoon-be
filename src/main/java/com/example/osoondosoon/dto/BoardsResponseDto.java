package com.example.osoondosoon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BoardsResponseDto {
    private List<BoardListResponseDto> data;
}
