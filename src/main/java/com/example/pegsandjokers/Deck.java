package com.example.pegsandjokers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck(){
        this.cards = new ArrayList<>();
        this.initializeDeck();
    }

    public void initializeDeck(){
        for (Value v : Value.values()){
            if (v.equals(Value.JOKER)){
                this.cards.add(new Card(null, Value.JOKER));
                this.cards.add(new Card(null, Value.JOKER));
            } else {
                for (Suit s : Suit.values()){
                    this.cards.add(new Card(s, v));
                }
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

}
