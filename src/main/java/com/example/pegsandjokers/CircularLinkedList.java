package com.example.pegsandjokers;

public class CircularLinkedList {

    private Node<T> head;

    public CircularLinkedList(){
        this.head = null;
    }

    public void insert(T data){
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node<T> temp = head;
            while (temp.next != head){
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
        }
    }
}
