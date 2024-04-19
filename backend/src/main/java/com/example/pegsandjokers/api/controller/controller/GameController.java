package com.example.pegsandjokers.api.controller.controller;

import com.example.pegsandjokers.api.controller.model.Board;
import com.example.pegsandjokers.api.controller.model.Game;
import com.example.pegsandjokers.api.controller.model.Turn;
import com.example.pegsandjokers.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("/board")
    public Game getGame(@RequestParam Integer id){
        Optional<Game> game = gameService.getGame(id);
        return (Game) game.orElse(null);
    }

    @GetMapping("/turn")
    public Turn getTurn(){
        return gameService.getTurn();
    }

    @GetMapping("/game")
    public ResponseEntity<?> makeNewGame(){
        Integer id = gameService.createGame();
        return ResponseEntity.ok().body("New game created! ID = " + Integer.toString(id));
    }

    @PostMapping("/play/turn")
    public ResponseEntity<?> playTurn(@RequestBody Turn turn) {
        boolean success = gameService.takeTurn(turn);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Invalid move!");
        }
    }
}
