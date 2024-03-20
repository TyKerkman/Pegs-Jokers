package com.example.pegsandjokers;

public class Hole {

    private boolean filled;
    private Player player;
    private Peg peg;
    private boolean isHeavensGate;

    public Hole(){
        this.filled = false;
        this.peg = null;
        this.isHeavensGate = false;
    }

    public Peg getPeg(){
        return this.peg;
    }

    public void addPeg(Peg peg){
        this.peg = peg;
        this.filled = true;
    }

    public void removePeg(){
        this.peg = null;
        this.filled = false;
    }

    public boolean getIsHeavensGate(){
        return this.isHeavensGate;
    }

    public void setHeavensGate(){
        this.isHeavensGate = true;
    }

    @Override
    public String toString(){
        //TODO
        return "";
    }
}
