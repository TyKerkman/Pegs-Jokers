package com.example.pegsandjokers;

public class Hole {

    private boolean filled;
    private Peg peg;

    public Hole(){
        this.filled = false;
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
}
