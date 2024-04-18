package com.example.pegsandjokers.service;

import com.example.pegsandjokers.api.controller.model.Board;
import com.example.pegsandjokers.api.controller.model.Card;
import com.example.pegsandjokers.api.controller.model.Game;
import com.example.pegsandjokers.api.controller.model.Peg;
import com.example.pegsandjokers.api.controller.model.Player;
import com.example.pegsandjokers.api.controller.model.Suit;
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
//        Player[] players = game.getPlayers();
//        for (Player p : players){
//            Peg peg = p.getPegs().getFirst();
//            game.getOut(peg);
//        }

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
        Player player = g.getPlayers()[turn.getPlayerID()];
        Peg p = getPeg(turn.getP(), player);
        Peg p2 = turn.getP2(); //TODO
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
        } else if (p.getHole() == null) {
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
        Card c = new Card(Suit.DIAMONDS, Value.NINE);
        Peg p = new Peg();
        Integer gameId = 1;
        return new Turn(playerID, c, p, gameId);
    }

    public Game getGame(Integer id){
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
}
