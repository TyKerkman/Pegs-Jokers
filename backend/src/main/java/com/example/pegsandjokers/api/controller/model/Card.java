package com.example.pegsandjokers.api.controller.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Card {
    private Value value;

    @JsonCreator
    public Card(@JsonProperty("value") Value value){
        this.value = value;
    }

    public Value getValue(){
        return this.value;
    }

}
