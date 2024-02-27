package com.example.pegsandjokers;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Card> hand;
    private String name;

    public Player(String name){
        this.hand = new ArrayList<>();
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public List<Card> getHand(){
        return this.hand;
    }

    public void addCardToHand(Card c){
        this.hand.add(c);
    }
}
