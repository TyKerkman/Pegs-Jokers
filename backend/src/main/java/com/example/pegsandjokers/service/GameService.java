package com.example.pegsandjokers.service;

import com.example.pegsandjokers.api.controller.model.Board;
import com.example.pegsandjokers.api.controller.model.Card;
import com.example.pegsandjokers.api.controller.model.Game;
import com.example.pegsandjokers.api.controller.model.Peg;
import com.example.pegsandjokers.api.controller.model.Player;
import com.example.pegsandjokers.api.controller.model.Turn;
import com.example.pegsandjokers.api.controller.model.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private List<Game> gameList;

    public GameService(){
        this.gameList = new ArrayList<>();

        Game game = new Game(1);

        this.gameList.add(game);
    }
    public Optional<Game> getGame(Integer id) {
        Optional<Game> optional = Optional.empty();
        for (Game game : this.gameList){
            if (id.equals(game.getId())){
                optional = Optional.of(game);
                return optional;
            }
        }
        return optional;
    }

    public boolean takeTurn(Turn turn) {
        Game g = getGameByID(turn.getGameID());
        Player player = g.getPlayers()[turn.getPlayerID()];
        Peg p = getPeg(turn.getP(), player);
        Peg p2 = turn.getP2();
        Card c = turn.getCard();
        int spaces = turn.getSpaces();

        if (p2 != null){
            Player player2 = g.getPlayers()[getNumPlayerFromColor(p2.getColor())];
            p2 = getPeg(turn.getP2(), player2);
            if (c.getValue().equals(Value.TWO)) {
                return g.swap(p, p2);
            } else if (c.getValue().equals(Value.JOKER)) {
                return g.kill(p, p2);
            } else if (c.getValue().equals(Value.SEVEN) || c.getValue().equals(Value.NINE)) {
                return g.splitMove(p, p2, c, spaces);
            }
        } else if (p.getInHome()) {
            return g.getOut(p);
        }
        else {
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
        Integer playerID = 0;
        Card c = new Card(Value.NINE);
        Peg p = new Peg();
        Peg p2 = null;
        Integer gameId = 1;
        int spaces = 0;
        return new Turn(playerID, c, p, p2, gameId, spaces);
    }

    public Game getGameByID(Integer id){
        for (Game g : this.gameList){
            if (g.getId().equals(id)){
                return g;
            }
        }
        return null;
    }

    public Peg getPeg(Peg p, Player player){
        for (Peg peg : player.getPegs()){
            if (p.equals(peg)){
                return peg;
            }
        }
        for (Peg peg : player.getPartner().getPegs()){
            if (p.equals(peg)){
                return peg;
            }
        }
        return null;
    }

    public int getNumPlayerFromColor(String color){
        return switch (color) {
            case "red" -> 0;
            case "fuchsia" -> 1;
            case "green" -> 2;
            case "blue" -> 3;
            default -> -1;
        };
    }

    public boolean isWinner(Integer gameID){
        Game g = getGameByID(gameID);
        return g != null && g.isWinner();
    }

    public Card newCard(Integer gameID){
        Game g = getGameByID(gameID);
        return g.getRandomCard();
    }
}
