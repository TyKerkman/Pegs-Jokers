package com.example.pegsandjokers;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int num;
    private String name;
    private List<Card> hand;
    private Player partner;

    public Player(int num, String name){
        this.num = num;
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public Player(int num, String name, Player partner){
        this.num = num;
        this.name = name;
        this.hand = new ArrayList<>();
        this.partner = partner;
    }

    public String getName(){
        return this.name;
    }

    public List<Card> getHand(){
        return this.hand;
    }

    public Player getPartner(){
        return this.partner;
    }

    public void addCardToHand(Card c){
        this.hand.add(c);
    }

}
