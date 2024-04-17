package com.example.pegsandjokers.service;

import com.example.pegsandjokers.api.controller.model.Board;
import com.example.pegsandjokers.api.controller.model.Game;
import com.example.pegsandjokers.api.controller.model.Peg;
import com.example.pegsandjokers.api.controller.model.Player;
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

        Game game = new Game(1);
        Player[] players = game.getPlayers();
        for (Player p : players){
            Peg peg = p.getPegs().getFirst();
//            System.out.println(p);
            game.getOut(peg);
        }

        this.gameList.add(game);
    }
    public Optional<Board> getBoard(Integer id) {
        Optional optional = Optional.empty();
        for (Game game : this.gameList){
            if (id == game.getId()){
                optional = Optional.of(game.getBoard());
                return optional;
            }
        }
        return optional;
    }
}
