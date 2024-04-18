package com.example.pegsandjokers.api.controller.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.UUID;

public class Hole {

    private UUID id;
    private UUID next;
    private UUID previous;
    private UUID fork;
    private int numPlayer;
    private Peg peg;
    private boolean isHeavensGate;
    private boolean isHomeStep;

    public Hole(UUID id, int numPlayer){
        this.id = id;
        this.numPlayer = numPlayer;
        this.peg = null;
        this.isHeavensGate = false;
        this.isHomeStep = false;
    }

    @JsonSerialize(using = PegSerializer.class)
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getNext() {
        return next;
    }

    public void setNext(UUID next) {
        this.next = next;
    }

    public UUID getPrevious() {
        return previous;
    }

    public void setPrevious(UUID previous) {
        this.previous = previous;
    }

    public UUID getFork() {
        return fork;
    }

    public void setFork(UUID fork) {
        this.fork = fork;
    }

    @Override
    public String toString(){
        String s = "id: " + this.id;
        s = (next == null) ? s : s + " next: " + this.next;
        s = (previous == null) ? s : s + " previous: " + this.previous;
        s = (fork == null) ? s : s + " fork: " + this.fork;
        return s;
    }
}
