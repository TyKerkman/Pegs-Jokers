package com.example.pegsandjokers.service;

import com.example.pegsandjokers.api.controller.model.*;
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
        Optional<Board> optional = Optional.empty();
        for (Game game : this.gameList){
            if (id.equals(game.getId())){
                optional = Optional.of(game.getBoard());
                return optional;
            }
        }
        return optional;
    }

    public boolean takeTurn(Turn turn) {
        Game g = getGame(turn.getGameID());
        Peg p = turn.getP();
        Peg p2 = turn.getP2();
        Card c = turn.getCard();
        int spaces = turn.getSpaces();

        if (p2 != null){
            if (c.getValue().equals(Value.TWO)) {
                return g.swap(p, p2);
            } else if (c.getValue().equals(Value.JOKER)) {
                return g.kill(p, p2);
            } else if (c.getValue().equals(Value.SEVEN) || c.getValue().equals(Value.NINE)) {
                return g.splitMove(p, p2, c, spaces);
            }
        } else {
            return g.move(p, c);
        }
        return false;
    }

    public Integer createGame(){
        Integer id = gameList.size();
        Game g = new Game(id);
        gameList.add(g);
        return id;
    }

    public Turn getTurn(){
        Card c = new Card(Suit.DIAMONDS, Value.NINE);
        Peg p = new Peg();
        Integer gameId = 5;
        return new Turn(c, p, gameId);
    }

    public Game getGame(Integer id){
        for (Game g : this.gameList){
            if (g.getId().equals(id)){
                return g;
            }
        }
        return null;
    }
}
