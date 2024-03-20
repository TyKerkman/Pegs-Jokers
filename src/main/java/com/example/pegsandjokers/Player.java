package com.example.pegsandjokers;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private int num;
    private String name;
    private List<Card> hand;
    private Player partner;
    private List<Peg> pegs;

    public Player(int num){
        this.num = num;
        this.hand = new ArrayList<>();
        this.pegs = new ArrayList<Peg>();
    }

    public Player(int num, String name){
        this.num = num;
        this.name = name;
        this.hand = new ArrayList<>();
        this.pegs = new ArrayList<Peg>();
    }

    public Player(int num, String name, Player partner){
        this.num = num;
        this.name = name;
        this.hand = new ArrayList<>();
        this.pegs = new ArrayList<Peg>();
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

    public List<Peg> getPegs(){
        return this.pegs;
    }

}
