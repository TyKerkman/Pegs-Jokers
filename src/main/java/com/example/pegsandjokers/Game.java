package com.example.pegsandjokers;

import com.sun.jdi.NativeMethodException;

public class Game {
    private Board board;
    private Player[] players;
    private Deck deck;

    public Game(Player[] players){
        this.board = new Board(players.length);
        this.players = players;
        this.deck = new Deck();
    }

    public void movePeg(Peg peg, int spaces, boolean forward){
        Hole[] loop = this.board.getLoop();
        Hole current = peg.getHole();
        //Finish
    }

    public boolean move(Peg peg, Card card){
        Value value = card.getValue();
        return switch (value) {
            case ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, NINE, TEN, JACK, QUEEN, KING -> {
                movePeg(peg, value.ordinal() + 1, true);
                yield true;
            }
            case EIGHT -> {
                movePeg(peg, value.ordinal() + 1, false);
                yield true;
            }
            default -> false;
        };
    }

    public boolean splitMove(Peg peg1, Peg peg2, Card card, int spacesForward){
        Value value = card.getValue();
        if (spacesForward >= value.ordinal() + 1){
            return false;
        }

        movePeg(peg1, spacesForward, true);
        movePeg(peg2, value.ordinal() + 1 - spacesForward, value.equals(Value.SEVEN));
        return true;
    }

    public boolean getOut(Card card){
        Value value = card.getValue();
        return switch (value) {
            case ACE, JACK, QUEEN, KING -> {
                //TODO
                yield true;
            }
            default -> false;
        };
    }
}
