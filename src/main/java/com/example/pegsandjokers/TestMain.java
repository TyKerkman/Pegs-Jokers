package com.example.pegsandjokers;

public class TestMain {
    public static void main(String[] args){
        Board b = new Board(4);
        Hole[] loop = b.getLoop();
        for (Hole h : loop){
            System.out.println(h);
        }
    }
}
