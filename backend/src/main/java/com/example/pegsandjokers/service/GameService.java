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

//    public void play(Game game){
//        Player[] players = game.getPlayers();
//        while(!game.isWinner()){
//            for (Player p: players){
////                takeTurn(game, p);
//            }
//        }
//    }

    /**
     * WORK IN PROGRESS!!!!
     */
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

    public Game getGame(Integer id){
        for (Game g : this.gameList){
            if (g.getId().equals(id)){
                return g;
            }
        }
        return null;
    }

    public Card saveCard(Card c){
        return null;
    }

    public Peg savePeg(Peg p){
        return null;
    }
}
