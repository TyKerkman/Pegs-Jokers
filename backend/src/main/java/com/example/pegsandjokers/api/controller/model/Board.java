package com.example.pegsandjokers.api.controller.model;
public class Board {

    public static final int SIZE_OF_BOARD_SEGMENT = 18;
    public static final int SIZE_OF_HEAVEN = 5;
    private final int NUM_PLAYERS;
    private Player[] players;
    private CircularLinkedList<Hole> loop;

    public Board(int numPlayers){
        this.NUM_PLAYERS = numPlayers;
        this.initializePlayers();
        this.initializeBoard();
    }

    public void initializePlayers(){
        this.players = new Player[NUM_PLAYERS];
        for (int i = 0; i < NUM_PLAYERS; i++){
            this.players[i] = new Player(i);
        }

        for (int i = 0; i < NUM_PLAYERS; i++){
            if (i < NUM_PLAYERS / 2){
                this.players[i].setPartner(this.players[i + NUM_PLAYERS / 2]);
            } else {
                this.players[i].setPartner(this.players[i - NUM_PLAYERS / 2]);
            }
        }
    }

    public void initializeBoard(){
        this.loop = new CircularLinkedList<Hole>();
        for (int i = 0; i < NUM_PLAYERS * SIZE_OF_BOARD_SEGMENT; i++){
            int numPlayer = i / SIZE_OF_BOARD_SEGMENT;
            Node<Hole> node = new Node<>(new Hole(numPlayer));
            loop.insert(node);
            if (i % SIZE_OF_BOARD_SEGMENT == 0){
                this.players[numPlayer].setHeavensGate(node.getData());
                node.getData().setHeavensGate();
                insertHeaven(node, numPlayer);
            }
            if (i % SIZE_OF_BOARD_SEGMENT == 5){
                node.getData().setHomeStep();
                this.players[numPlayer].setHomeStep(node.getData());
            }
        }
    }

    public void insertHeaven(Node<Hole> node, int num){
        LinkedList<Hole> heaven = new LinkedList<>();
        for (int i = 0; i < SIZE_OF_HEAVEN; i++) {
            Node<Hole> newNode = new Node<>(new Hole(num));
            heaven.insert(newNode);
        }
        node.setFork(heaven.getFirst());
    }

    public Player[] getPlayers(){
        return this.players;
    }

    public CircularLinkedList<Hole> getLoop(){
        return this.loop;
    }
}