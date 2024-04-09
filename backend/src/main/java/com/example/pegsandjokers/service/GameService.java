package com.example.pegsandjokers.service;

import com.example.pegsandjokers.api.controller.model.Game;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private List<Game> gameList;

    public GameService(){
        this.gameList = new ArrayList<>();

        Game game1 = new Game(1);
        Game game2 = new Game(2);
        Game game3 = new Game(3);
        Game game4 = new Game(4);

        this.gameList.addAll(Arrays.asList(game1, game2, game3, game4));
    }
    public Optional<Game> getGame(Integer id) {
        Optional optional = Optional.empty();
        for (Game game : this.gameList){
            if (id == game.getId()){
                optional = Optional.of(game);
                return optional;
            }
        }
        return optional;
    }
}
