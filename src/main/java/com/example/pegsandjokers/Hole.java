package com.example.pegsandjokers;

public class Hole {

    private boolean filled;
    private int numPlayer;
    private boolean isHeavensGate;

    private boolean isHomeStep;

    public Hole(int numPlayer){
        this.filled = false;
        this.numPlayer = numPlayer;
        this.isHeavensGate = false;
        this.isHomeStep = false;
    }

    public boolean getFilled(){
        return this.filled;
    }

    public void setFilled(boolean filled){
        this.filled = filled;
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

    public void setHomeStep(boolean homeStep) {
        isHomeStep = homeStep;
    }

    @Override
    public String toString(){
        //TODO
        return "";
    }
}
