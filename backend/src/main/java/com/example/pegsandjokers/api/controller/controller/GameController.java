package com.example.pegsandjokers.api.controller.controller;

import com.example.pegsandjokers.api.controller.model.Game;
import com.example.pegsandjokers.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("/game")
    public Game getGame(@RequestParam Integer id){
        Optional<Game> game = gameService.getGame(id);
        return (Game) game.orElse(null);
    }
}
