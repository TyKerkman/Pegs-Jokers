package com.example.pegsandjokers;

public class Game {
    private Board board;
    private Player[] players;
    private Deck deck;

    public Game(Player[] players){
        this.board = new Board(players.length);
        this.players = players;
        this.deck = new Deck();
    }

    public void movePeg(Card card){
        switch(card.getValue()){

        }
    }
}
