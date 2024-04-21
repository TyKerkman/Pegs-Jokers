package com.example.pegsandjokers.api.controller.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize(using = PlayerSerializer.class)
public class Player{

    private Integer id;
    private String name;
    private String color;
    private List<Card> hand;
    private Player partner;
    private List<Peg> pegs;

    private Hole heavensGate;
    private Hole homeStep;

    public Player(Integer id, String color){
        this.id = id;
        this.color = color;
        this.hand = new ArrayList<>();
        this.pegs = new ArrayList<Peg>();
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

    public void setPartner(Player p){
        this.partner = p;
    }

    public void addCardToHand(Card c){
        this.hand.add(c);
    }

    public void setPegs(List<Peg> pegs){
        this.pegs = pegs;
    }
    public List<Peg> getPegs(){
        return this.pegs;
    }

    public Integer getId(){
        return this.id;
    }

    public Hole getHeavensGate(){
        return this.heavensGate;
    }

    public void setHeavensGate(Hole h){
        this.heavensGate = h;
    }

    public Hole getHomeStep(){
        return this.homeStep;
    }

    public void setHomeStep(Hole h){
        this.homeStep = h;
    }

    public int getPegsInHome(){
        int count = 0;
        for (Peg p : this.pegs){
            if (p.getInHome()){
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Player p)) return false;
        return this.id.equals(p.getId());
    }

    @Override
    public String toString(){
        String s = "Player " + Integer.toString(this.id) + "\n";
        s += "Heaven's Gate: " + this.heavensGate + "\n";
        s += "Home Step: " + this.homeStep + "\n";
        return s;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
