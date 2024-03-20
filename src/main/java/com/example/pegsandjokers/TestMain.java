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
                System.out.println("Has Fork! ");
                Node <Hole> fork = temp.getFork();
                int count_fork = 0;
                while (fork != null){
                    System.out.println("Fork " + Integer.toString(count_fork));
                    fork = fork.getNext();
                    count_fork++;
                }
            }
            temp = temp.getPrevious();
            count++;
        } while (temp != head);
    }
}