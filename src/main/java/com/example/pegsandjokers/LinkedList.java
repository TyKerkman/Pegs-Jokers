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
            this.last = null;
        } else {
            Node<E> temp = this.first;
            while (temp.getNext() != this.last){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(this.last);
        }
    }

    public void insert(E data){
        Node<E> newNode = new Node<E>(data);

        if (this.first == null) {
            this.first = newNode;
            this.last = null;
        } else {
            Node<E> temp = this.first;
            while (temp.getNext() != this.last){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(this.last);
        }
    }

    public Node<E> getFirst(){
        return this.first;
    }
}
