package com.example.pegsandjokers;

public class TestMain {
    public static void main(String[] args){
        Board b = new Board(4);
        CircularLinkedList<Hole> loop = b.getLoop();
        Node<Hole> head = loop.getHead();
        Node<Hole> temp = head;
        int count = 0;

        do {
            System.out.println(temp + Integer.toString(count));
            if (temp.getFork() != null) {
                System.out.println("Has Fork!");
            }
            temp = temp.getNext();
            count++;
        } while (temp != head);
    }
}
