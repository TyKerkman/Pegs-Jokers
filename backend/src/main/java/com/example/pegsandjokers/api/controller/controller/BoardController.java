package com.example.pegsandjokers.api.controller.controller;

import com.example.pegsandjokers.api.controller.model.Board;
import com.example.pegsandjokers.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public Board getBoard(@RequestParam Integer id){
        Optional<Board> board = boardService.getBoard(id);
        return (Board) board.orElse(null);
    }
}