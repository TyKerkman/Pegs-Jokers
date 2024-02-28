package com.example.pegsandjokers;

public class Peg {
    private Hole hole;
    private boolean inHome;

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
}
