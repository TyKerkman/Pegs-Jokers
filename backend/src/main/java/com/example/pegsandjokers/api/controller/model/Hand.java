package com.example.pegsandjokers.api.controller.model;

public class Hand {
    private Integer playerID;
    private Card[] hand;
    public static final int SIZE_OF_HAND = 5;

    public Hand(Integer playerID, Deck deck){
        this.playerID = playerID;
        this.hand = new Card[SIZE_OF_HAND];
        for (int i = 0; i < SIZE_OF_HAND; i++){
            this.hand[i] = deck.getRandomCard();
        }
    }

    public Card[] getHand() {
        return this.hand;
    }

    public Integer getPlayerID() {
        return this.playerID;
    }
}
