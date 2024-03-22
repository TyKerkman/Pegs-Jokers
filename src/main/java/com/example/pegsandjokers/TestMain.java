package com.example.pegsandjokers;

public class TestMain {
    public static void main(String[] args){
        Board b = new Board(4);
        CircularLinkedList<Hole> loop = b.getLoop();
        Node<Hole> head = loop.getHead();
        Node<Hole> temp = head;
        int count = 0;

        do {
            System.out.println(temp + Integer.toString(count) + ". Player: " + Integer.toString(temp.getData().getNumPlayer()));
            if (temp.getFork() != null) {
                System.out.println("Has Fork! ");
                Node <Hole> fork = temp.getFork();
                int count_fork = 0;
                while (fork != null){
                    System.out.println("Fork " + Integer.toString(count_fork) + ". Player: " + Integer.toString(temp.getData().getNumPlayer()));
                    fork = fork.getNext();
                    count_fork++;
                }
            }

            if (temp.getData().isHeavensGate()){
                System.out.println("HEAVENS GATE FOR PLAYER " + Integer.toString(temp.getData().getNumPlayer()));
            }

            if (temp.getData().isHomeStep()){
                System.out.println("HOME STEP FOR PLAYER " + Integer.toString(temp.getData().getNumPlayer()));
            }

            temp = temp.getNext();
            count++;
        } while (temp != head);
    }
}