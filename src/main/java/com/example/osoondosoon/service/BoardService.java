package com.example.osoondosoon.service;

import com.example.osoondosoon.dto.BoardListResponseDto;
import com.example.osoondosoon.dto.BoardRequestDto;
import com.example.osoondosoon.dto.BoardResponseDto;
import com.example.osoondosoon.dto.BoardsResponseDto;
import com.example.osoondosoon.entity.Board;
import com.example.osoondosoon.entity.BoardCategory;
import com.example.osoondosoon.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    // 글 생성
    public BoardResponseDto createBoard(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return new BoardResponseDto(board);
    }

    // ✅ 전체 목록(카테고리 필터 포함)
    public BoardsResponseDto findBoards(BoardCategory category) {
        List<Board> boardList = (category == null)
                ? boardRepository.findAllByOrderByCreatedAtDesc()
                : boardRepository.findByCategoryOrderByCreatedAtDesc(category);

        List<BoardListResponseDto> data = boardList.stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());

        return new BoardsResponseDto(data);
    }

    // 글 하나 가져오기
    public BoardResponseDto findOneBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("조회 실패")
        );
        return new BoardResponseDto(board);
    }

    // 글 수정
    @Transactional
    public Long updateBoard(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getBoardId();
    }

    // 삭제
    @Transactional
    public Long deleteBoard(Long id) {
        boardRepository.deleteById(id);
        return id;
    }
}
