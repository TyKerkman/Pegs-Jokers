package com.example.pegsandjokers;

public class Hole {

    private int index;
    private boolean filled;
    private Peg peg;
    private boolean isHeavensGate;

    public Hole(int index){
        this.index = index;
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

    public void setIndex(int index){
        this.index = index;
    }

    public int getIndex(){
        return this.index;
    }

    public void setHeavensGate(){
        this.isHeavensGate = true;
    }
}
