package com.example.pegsandjokers;

import java.util.LinkedList;

public class Node<E> {

    private E data;
    private Node<E> next;
    private LinkedList<Node<E>> fork;

    public Node(E data){
        this.data = data;
        this.next = null;
        this.fork = null;
    }

    public E getData(){
        return this.data;
    }

    public Node<E> getNext(){
        return this.next;
    }

    public void setNext(Node<E> next){
        this.next = next;
    }

    public void setFork(LinkedList<Node<E>> fork){
        this.fork = fork;
    }

    public LinkedList<Node<E>> getFork(){
        return this.fork;
    }
}
