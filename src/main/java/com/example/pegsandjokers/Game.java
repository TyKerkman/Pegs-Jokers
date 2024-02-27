package com.example.pegsandjokers;

public class Game {
    private Board board;
    private Player[] players;
    private Deck deck;

    public Game(Player[] players){
        this.board = new Board();
        this.players = players;
        this.deck = new Deck();
        this.deck.initializeDeck();
    }


}
