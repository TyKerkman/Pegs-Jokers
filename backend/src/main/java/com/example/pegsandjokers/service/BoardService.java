package com.example.pegsandjokers.service;

import com.example.pegsandjokers.api.controller.model.Board;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    private List<Board> boardList;

    public BoardService(){
        this.boardList = new ArrayList<>();

//        Board board1 = new Board(1);
//        Board board2 = new Board(2);
//        Board board3 = new Board(3);
//        Board board4 = new Board(4);
//
//        this.boardList.addAll(Arrays.asList(board1, board2, board3, board4));
    }
    public Optional<Board> getBoard(Integer id) {
        Optional<Board> optional = Optional.empty();
        for (Board board : this.boardList){
            if (id.equals(board.getId())){
                optional = Optional.of(board);
                return optional;
            }
        }
        return optional;
    }
}
