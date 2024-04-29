package com.example.pegsandjokers.service;

import com.example.pegsandjokers.api.controller.model.*;
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
        Player player = g.getPlayers()[g.getPlayerTurn()];
        Peg p = getPeg(turn.getP(), player);
        Peg p2 = turn.getP2();
        Card c = turn.getCard();
        int spaces = turn.getSpaces();

        if (p == null){
            return false;
        } else if (p2 != null){
            Player player2 = g.getPlayers()[getNumPlayerFromColor(p2.getColor())];
            p2 = getPeg(turn.getP2(), player2);
            if (c.getValue().equals(Value.TWO)) {
                return g.swap(p, p2);
            } else if (c.getValue().equals(Value.JOKER)) {
                if (p2.getInHome()){
                    return false;
                }
                return g.kill(p, p2);
            } else if (c.getValue().equals(Value.SEVEN) || c.getValue().equals(Value.NINE)) {
                return g.splitMove(p, p2, c, spaces);
            }
        } else if (p.getInHome()) {
            if (!(c.getValue().equals(Value.JOKER) || c.getValue().equals(Value.ACE) || c.getValue().equals(Value.JACK) || c.getValue().equals(Value.KING) || c.getValue().equals(Value.QUEEN))){
                return false;
            }
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
        Card c = new Card(Value.NINE);
        Peg p = new Peg();
        Peg p2 = null;
        Integer gameId = 1;
        int spaces = 0;
        return new Turn(c, p, p2, gameId, spaces);
    }

    public Game getGameByID(Integer id){
        for (Game g : this.gameList){
            if (g.getId().equals(id)){
                return g;
            }
        }
        return null;
    }

    public boolean updateCard(Turn turn){
        Game g = getGameByID(turn.getGameID());
        Hand hand = g.getHands()[g.getPlayerTurn()];
        Card[] cards = hand.getCards();
        for (int i = 0; i < cards.length; i++){
            if (cards[i].equals(turn.getCard())){
                cards[i] = g.getRandomCard();
                return true;
            }
        }
        return false;
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

    public void incrementPlayerTurn(Integer gameID){
        Game g = getGameByID(gameID);
        g.updatePlayerTurn();
    }
}
