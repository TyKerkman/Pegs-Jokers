package com.example.pegsandjokers.api.controller.model;

public class Card {
    private Value value;

    public Card(Value value){
        this.value = value;
    }

    public Value getValue(){
        return this.value;
    }

}
