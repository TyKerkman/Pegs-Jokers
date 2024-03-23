package com.example.pegsandjokers;

public class LinkedList<E> {

    private Node<E> first;
    private Node<E> last;

    public LinkedList(){
        this.first = null;
        this.last = null;
    }

    public void insert(Node<E> newNode){
        if (this.first == null) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
        }
        this.last = newNode;
    }

    public Node<E> getFirst(){
        return this.first;
    }

    public Node<E> getLast(){
        return this.last;
    }
}