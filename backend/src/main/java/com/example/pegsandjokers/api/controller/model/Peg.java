package com.example.pegsandjokers.api.controller.model;

import java.awt.*;

public class Peg {
    private Hole hole;
    private boolean inHome;
    private boolean inHeaven;

    private Player player;
    private String color;

    public Hole getHole(){
        return this.hole;
    }

    public void setHole(Hole hole){
        this.hole = hole;
    }

    public boolean getInHome(){
        return this.inHome;
    }

    public void sendHome(){
        this.inHome = true;
        this.hole = null;
    }

    public void removeFromHome(){
        this.inHome = false;
    }

    public boolean getInHeaven(){
        return this.inHeaven;
    }

    public void setInHeaven(boolean inHeaven){
        this.inHeaven = inHeaven;
    }

    public Player getPlayer(){
        return this.player;
    }

    public void setPlayer(Player p){
        this.player = p;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
