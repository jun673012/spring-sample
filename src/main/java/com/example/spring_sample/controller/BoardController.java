package com.example.spring_sample.controller;

import com.example.spring_sample.domain.Board;
import com.example.spring_sample.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @Operation(summary = "View All Posts Registered By Users", description = "사용자들이 등록한 게시글을 모두 본다.", tags = { "Board Controller" })
    @GetMapping("/board")
    public ResponseEntity<?> getAllBoards() {
        return new ResponseEntity(boardService.getAllBoards(), HttpStatus.OK);
    }

    @Operation(summary = "View User Registered Post", description = "사용자의 게시글을 본다.", tags = { "Board Controller" })
    @GetMapping("/board/{id}")
    public ResponseEntity<?> getBoard(@PathVariable("id") Long id) {
        return new ResponseEntity(boardService.getBoard(id), HttpStatus.OK);
    }

    @Operation(summary = "Register Post", description = "게시글을 쓴다.", tags = { "Board Controller" })
    @PostMapping("/board")
    public ResponseEntity<?> postBoard(@RequestBody Board board) {
        return new ResponseEntity(boardService.postBoard(board), HttpStatus.CREATED);
    }

    @Operation(summary = "Modify Post", description = "게시글을 수정한다.", tags = { "Board Controller" })
    @PutMapping("/board/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable Long id, @RequestBody Board board) {
        return new ResponseEntity(boardService.updateBoard(id, board), HttpStatus.OK);
    }

    @Operation(summary = "Delete Post", description = "게시글을 삭제한다.", tags = { "Board Controller" })
    @DeleteMapping("/board/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
