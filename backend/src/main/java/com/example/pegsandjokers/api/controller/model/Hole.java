package com.example.pegsandjokers.api.controller.model;

public class Hole {

    private int numPlayer;
    private Peg peg;
    private boolean isHeavensGate;
    private boolean isHomeStep;

    public Hole(int numPlayer){
        this.numPlayer = numPlayer;
        this.peg = null;
        this.isHeavensGate = false;
        this.isHomeStep = false;
    }

    public Peg getPeg() {
        return peg;
    }

    public void setPeg(Peg peg) {
        this.peg = peg;
    }
    
    public void removePeg(){
        this.peg = null;
    }

    public boolean isHeavensGate(){
        return this.isHeavensGate;
    }

    public void setHeavensGate(){
        this.isHeavensGate = true;
    }

    public int getNumPlayer(){
        return this.numPlayer;
    }

    public boolean isHomeStep() {
        return isHomeStep;
    }

    public void setHomeStep() {
        isHomeStep = true;
    }

    @Override
    public String toString(){
        //TODO
        return "";
    }
}
