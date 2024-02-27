package com.example.pegsandjokers;

public class CircularLinkedList<E> {

    private Node<E> head;

    public CircularLinkedList(){
        this.head = null;
    }

    public void insert(Node<E> newNode){
        if (head == null) {
            this.head = newNode;
            this.head.setNext(this.head);
        } else {
            Node<E> temp = this.head;
            while (temp.getNext() != this.head){
                temp = temp.getNext();
            }

            temp.setNext(newNode);
            newNode.setNext(this.head);
        }
    }

    public void insert(E data){
        Node<E> newNode = new Node<E>(data);

        if (head == null) {
            this.head = newNode;
            this.head.setNext(this.head);
        } else {
            Node<E> temp = this.head;
            while (temp.getNext() != this.head){
                temp = temp.getNext();
            }

            temp.setNext(newNode);
            newNode.setNext(this.head);
        }
    }

    public Node<E> getHead(){
        return this.head;
    }
}
