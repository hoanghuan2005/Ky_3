/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_linkedlist;

/**
 *
 * @author SUPPER LOQ
 */
public class Node<T> {

    private T info;
    public Node next;

    public Node() {
    }

    public Node(T info, Node next) {
        this.info = info;
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(int val) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
