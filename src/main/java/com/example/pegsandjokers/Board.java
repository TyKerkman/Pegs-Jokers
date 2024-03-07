package com.example.pegsandjokers;
public class Board {

    public static final int SIZE_OF_BOARD_SEGMENT = 18;
    public static final int SIZE_OF_HEAVEN = 5;
    private final int NUM_PLAYERS;
    private Hole[] loop;

    public Board(int numPlayers){
        this.NUM_PLAYERS = numPlayers;
        this.initializeBoard();
    }

    public void initializeBoard(){
        this.loop = new Hole[NUM_PLAYERS * SIZE_OF_BOARD_SEGMENT];
        for (int i = 0; i < NUM_PLAYERS * SIZE_OF_BOARD_SEGMENT; i++){
            this.loop[i] = new Hole(i);
            if (i % SIZE_OF_BOARD_SEGMENT == 0){
                this.loop[i].setHeavensGate();
            }
        }
    }

    public Hole[] getLoop(){
        return this.loop;
    }
}
