package com.example.spring_sample.service;

import com.example.spring_sample.domain.Board;
import com.example.spring_sample.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<Board> getAllBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards;
    }

    @Transactional(readOnly = true)
    public Board getBoard(Long id) {
        Board board = boardRepository.findById(id).get();
        return board;
    }

    @Transactional
    public Board postBoard(Board board) {
        return boardRepository.save(board);
    }

    @Transactional
    public Board updateBoard(Long id, Board boardRequest) {
        Board board = boardRepository.findById(id).get();
        board.setTitle(boardRequest.getTitle());
        board.setContent(boardRequest.getContent());
        return board;
    }

    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

}
