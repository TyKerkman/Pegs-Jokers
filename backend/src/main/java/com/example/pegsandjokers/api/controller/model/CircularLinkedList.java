package com.example.pegsandjokers.api.controller.model;

public class CircularLinkedList<E> {

    private Node<E> head;

    public CircularLinkedList(){
        this.head = null;
    }

    public void insert(Node<E> newNode){
        if (head == null) {
            this.head = newNode;
            this.head.setPrevious(this.head);
            this.head.setNext(this.head);
        } else {
            Node<E> tail = this.head.getPrevious();
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            newNode.setNext(this.head);
            this.head.setPrevious(newNode);
        }
    }

    public Node<E> getHead(){
        return this.head;
    }

    public Node<E> get(E element) {
        if (head == null) {
            return null;
        }

        Node<E> current = head;
        do {
            if (current.getData().equals(element)) {
                return current;
            }
            current = current.getNext();
        } while (current != head);

        return null;
    }
}