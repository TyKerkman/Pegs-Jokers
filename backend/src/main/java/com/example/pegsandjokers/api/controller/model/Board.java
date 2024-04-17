package com.example.pegsandjokers.api.controller.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Board {

    public static final int SIZE_OF_BOARD_SEGMENT = 18;
    public static final int SIZE_OF_HEAVEN = 5;
    private Integer id;
    private final int NUM_PLAYERS;
    private Player[] players;
    private Hole[] loop;
    private Hole[][] heavens;

    public Board(Integer id, Player[] players){
        this.NUM_PLAYERS = 4;
        this.id = id;
        this.players = players;
        this.initializeBoard();
    }

    public void initializeBoard(){
        final int BOARD_SIZE = NUM_PLAYERS * SIZE_OF_BOARD_SEGMENT;
        this.loop = new Hole[BOARD_SIZE];
        this.heavens = new Hole[NUM_PLAYERS][SIZE_OF_HEAVEN];
        for (int i = 0; i < BOARD_SIZE; i++){
            int numPlayer = i / SIZE_OF_BOARD_SEGMENT;
            Hole h = new Hole(UUID.randomUUID(), numPlayer);
            this.loop[i] = h;
            if (i % SIZE_OF_BOARD_SEGMENT == 2){
                this.players[numPlayer].setHeavensGate(h);
                h.setHeavensGate();
                insertHeaven(h, numPlayer);
            }
            if (i % SIZE_OF_BOARD_SEGMENT == 5){
                h.setHomeStep();
                this.players[numPlayer].setHomeStep(h);
            }
        }

        for (int i = 0; i < BOARD_SIZE; i++){
            int previousIndex = (i == 0) ? (BOARD_SIZE - 1) : (i - 1);
            this.loop[i].setNext(this.loop[(i+1) % BOARD_SIZE].getId());
            this.loop[i].setPrevious(this.loop[previousIndex].getId());
        }
    }

    public void insertHeaven(Hole gate, int num){
        Hole[] heaven = new Hole[SIZE_OF_HEAVEN];
        for (int i = 0; i < heaven.length; i++) {
            Hole h = new Hole(UUID.randomUUID(), num);
            heaven[i] = h;
        }

        for (int i = 0; i < heaven.length - 1; i++){
            heaven[i].setNext(heaven[i+1].getId());
        }

        gate.setFork(heaven[0].getId());
        this.heavens[num] = heaven;
    }

    public Hole[] getLoop(){
        return this.loop;
    }

    public int getHoleIndex(UUID id) {
        for (int i = 0; i < loop.length; i++){
            if (this.loop[i].getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public Integer getId(){
        return this.id;
    }

    public Hole[][] getHeavens() {
        return this.heavens;
    }
}