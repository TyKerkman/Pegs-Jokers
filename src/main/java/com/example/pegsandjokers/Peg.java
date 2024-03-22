package com.example.pegsandjokers;

public class Peg {
    private Hole hole;
    private boolean inHome;
    private boolean inHeaven;

    private Player player;

    public Hole getHole(){
        return this.hole;
    }

    public void setHole(Hole hole){
        this.hole = hole;
    }

    public boolean getInHome(){
        return this.inHome;
    }

    public void setInHome(boolean inHome){
        this.inHome = inHome;
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
}
