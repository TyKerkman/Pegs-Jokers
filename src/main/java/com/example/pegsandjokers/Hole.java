package com.example.pegsandjokers;

public class Hole {

    private boolean filled;
    private int numPlayer;
    private boolean isHeavensGate;

    public Hole(int numPlayer){
        this.filled = false;
        this.numPlayer = numPlayer;
        this.isHeavensGate = false;
    }

    public boolean getFilled(){
        return this.filled;
    }

    public void setFilled(boolean filled){
        this.filled = filled;
    }

    public boolean getIsHeavensGate(){
        return this.isHeavensGate;
    }

    public void setHeavensGate(){
        this.isHeavensGate = true;
    }

    public int getNumPlayer(){
        return this.numPlayer;
    }

    @Override
    public String toString(){
        //TODO
        return "";
    }
}
